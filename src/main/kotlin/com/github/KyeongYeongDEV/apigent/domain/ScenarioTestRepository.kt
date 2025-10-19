package com.github.KyeongYeongDEV.apigent.domain

import org.springframework.data.repository.kotlin.CoroutineCrudRepository

interface ScenarioTestRepository  : CoroutineCrudRepository<ScenarioTest, Long>