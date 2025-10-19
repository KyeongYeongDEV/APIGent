package com.github.KyeongYeongDEV.apigent.agent

data class ScenarioTestRequest(
    // 예: "http://54.180.88.182:8000"
    val baseUrl: String,
    val scenario : String
)

data class ScenarioTestResponse(
    val testId : Long,
    val userScenario : String,
    val aiPlan : String,
    val status : String
)