package com.github.KyeongYeongDEV.apigent.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories
import org.springframework.web.reactive.function.client.WebClient

@Configuration
@EnableR2dbcRepositories(basePackages = ["com.github.KyeongYeongDEV.apigent.domain"])
class R2dbcConfig {

    @Bean
    fun webClient(): WebClient {
        return WebClient.builder()
            .defaultHeader("Content-Type", "application/json")
            .build()
    }
}