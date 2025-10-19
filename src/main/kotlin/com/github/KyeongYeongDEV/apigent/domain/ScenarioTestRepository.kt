package com.github.KyeongYeongDEV.apigent.domain

import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ScenarioTestRepository  : CoroutineCrudRepository<ScenarioTest, Long>