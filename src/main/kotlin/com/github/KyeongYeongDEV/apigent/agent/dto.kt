package com.github.KyeongYeongDEV.apigent.agent

data class ScenarioTestRequest(
    val swaggerUrl : String,
    val scenario : String
)

data class ScenarioTestResponse(
    val testId : Long,
    val userScenario : String,
    val aiPlan : String,
    val status : String
)