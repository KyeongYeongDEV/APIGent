package com.github.KyeongYeongDEV.apigent.common

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.awaitBody

@Component
class GeminiClient (
    private val webClient: WebClient,

    @Value("\${GEMINI_API_KEY}")
    private val apiKey : String,
){
    private val geminiUrl = "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.5-flash-latest:generateContent"

    suspend fun generateText(prompt : String) : String {
        val request = GeminiRequest(contents = listOf(Content(parts = listOf(Part(text = prompt)))))

        val response = webClient.post()
            .uri("$geminiUrl?key=$apiKey")
            .bodyValue(request)
            .retrieve()
            .awaitBody<GeminiResponse>()

        return response.candidates.firstOrNull()?.content?.parts?.firstOrNull()?.text
            ?: throw RuntimeException("Failed to get response from Gemini API")
    }
}

private data class GeminiRequest(val contents: List<Content>)
private data class Content(val parts: List<Part>)
private data class Part(val text: String)
private data class GeminiResponse(val candidates: List<Candidate>)
private data class Candidate(val content: Content)