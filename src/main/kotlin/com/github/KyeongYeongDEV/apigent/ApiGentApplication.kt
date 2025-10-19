package com.github.KyeongYeongDEV.apigent

import io.github.cdimascio.dotenv.dotenv
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ApiGentApplication

fun main(args: Array<String>) {
    dotenv {
        ignoreIfMissing = true
        systemProperties = true
    }

    runApplication<ApiGentApplication>(*args)
}

