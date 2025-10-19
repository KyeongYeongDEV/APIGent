package com.github.KyeongYeongDEV.apigent.agent

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/agent")
class AgentController(
    private val agentService: AgentService
) {

    @PostMapping("/run-test")
    suspend fun runTest(@RequestBody request: ScenarioTestRequest): ScenarioTestResponse {
        val resultEntity = agentService.startTest(request)

        return ScenarioTestResponse(
            testId = resultEntity.id!!,
            userScenario = resultEntity.userScenario,
            aiPlan = resultEntity.aiPlan ?: "No plan generated",
            status = resultEntity.status
        )
    }
}