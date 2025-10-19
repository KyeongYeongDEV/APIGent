package com.github.KyeongYeongDEV.apigent.agent

import com.github.KyeongYeongDEV.apigent.common.client.GeminiClient
import com.github.KyeongYeongDEV.apigent.domain.ScenarioTest
import com.github.KyeongYeongDEV.apigent.domain.ScenarioTestRepository
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.awaitBodilessEntity
import org.springframework.web.reactive.function.client.awaitBody

@Service
class AgentService(
    private val scenarioTestRepository: ScenarioTestRepository,
    private val geminiClient: GeminiClient,
    private val webClient: WebClient
) {
    private val log = LoggerFactory.getLogger(javaClass)

    private val candidatePaths = listOf(
        "/v3/api-docs",
        "/api-json",
        "/docs-json",
        "/openapi.json",
        "/swagger.json",
        "/api/swagger.json",
        "/api/v3/api-docs",
        "/api/v3/openapi.json"
    )

    suspend fun startTest(request: ScenarioTestRequest): ScenarioTest {
        val swaggerUrl = findSwaggerSpecUrl(request.baseUrl)
        log.info("✅ Swagger Spec URL discovered: {}", swaggerUrl)

        val swaggerSpec = fetchSpecFromUrl(swaggerUrl)
        val prompt = createTestPlanPrompt(swaggerSpec, request.scenario)
        log.info("--> Sending prompt to AI:\n$prompt")

        val aiPlan = geminiClient.generateText(prompt)
        log.info("<-- Received AI plan:\n$aiPlan")

        val scenarioTest = ScenarioTest(
            swaggerUrl = swaggerUrl,
            userScenario = request.scenario,
            aiPlan = aiPlan,
            status = "PLAN_GENERATED"
        )
        return scenarioTestRepository.save(scenarioTest)
    }

    private suspend fun findSwaggerSpecUrl(baseUrl: String): String {
        return candidatePaths.asFlow()
            .map { path ->
                val testUrl = "${baseUrl.removeSuffix("/")}$path" // URL 조합
                log.info("Probing for Swagger Spec at: {}", testUrl)
                try {
                    webClient.head().uri(testUrl).retrieve().awaitBodilessEntity()
                    testUrl
                } catch (e: Exception) {
                    null
                }
            }
            .firstOrNull { it != null }
            ?: throw RuntimeException("Could not find a valid Swagger/OpenAPI specification from the base URL: $baseUrl")
    }

    private suspend fun fetchSpecFromUrl(url: String): String {
        return webClient.get().uri(url).retrieve().awaitBody()
    }

    private fun createTestPlanPrompt(swaggerSpec: String, userScenario: String): String {
        return """
            You are an expert API testing agent.
            Based on the following OpenAPI (Swagger) specification and user scenario,
            create a single, concrete HTTP request plan in JSON format.
            The plan must include "method" and "path".
            ## OpenAPI Specification:
            ```
            $swaggerSpec
            ```
            ## User Scenario:
            "$userScenario"
            ## Output Format (JSON only):
            {
              "method": "...",
              "path": "..."
            }
        """.trimIndent()
    }
}