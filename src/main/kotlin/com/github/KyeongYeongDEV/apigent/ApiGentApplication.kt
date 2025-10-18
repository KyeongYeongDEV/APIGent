package com.github.KyeongYeongDEV.apigent

import io.github.cdimascio.dotenv.dotenv
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories

@EnableR2dbcRepositories
@SpringBootApplication
class ApiGentApplication

fun main(args: Array<String>) {

    dotenv {
        ignoreIfMissing = true
        systemProperties = true
    }

    runApplication<ApiGentApplication>(*args)
}
