package com.github.KyeongYeongDEV.apigent.agent

import com.github.KyeongYeongDEV.apigent.common.GeminiClient
import com.github.KyeongYeongDEV.apigent.domain.ScenarioTest
import com.github.KyeongYeongDEV.apigent.domain.ScenarioTestRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.awaitBody

@Service
class AgentService(
    private val scenarioTestRepository: ScenarioTestRepository,
    private val geminiClient: GeminiClient,
    private val webClient: WebClient
) {
    private val log = LoggerFactory.getLogger(javaClass)

    suspend fun startTest(request: ScenarioTestRequest): ScenarioTest {
        val swaggerSpec = fetchSpecFromUrl(request.swaggerUrl)
        val prompt = createTestPlanPrompt(swaggerSpec, request.scenario)
        log.info("--> Sending prompt to AI:\n$prompt")

        val aiPlan = geminiClient.generateText(prompt)
        log.info("<-- Received AI plan:\n$aiPlan")

        val scenarioTest = ScenarioTest(
            swaggerUrl = request.swaggerUrl,
            userScenario = request.scenario,
            aiPlan = aiPlan,
            status = "PLAN_GENERATED"
        )
        return scenarioTestRepository.save(scenarioTest)
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