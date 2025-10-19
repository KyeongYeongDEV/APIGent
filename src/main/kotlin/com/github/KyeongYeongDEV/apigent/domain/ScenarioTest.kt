package com.github.KyeongYeongDEV.apigent.domain

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import java.time.LocalDateTime


data class ScenarioTest(
    @Id
    val id : Long? = null,

    @Column("swagger_url")
    val swaggerUrl : String,

    @Column("user_scenario")
    val userScenario : String,

    @Column("ai_plan")
    val aiPlan : String? = null,

    var status: String,

    @Column("result_details")
    var resultDetails: String? = null,
    @Column("duration_ms")
    var durationMs: Long? = null,
    @Column("created_at")
    val createdAt: LocalDateTime = LocalDateTime.now()
)