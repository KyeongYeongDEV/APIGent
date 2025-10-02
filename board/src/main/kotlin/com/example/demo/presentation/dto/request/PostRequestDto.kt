package com.example.demo.presentation.dto.request

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class PostRequestDto(
    @field:NotBlank(message = "제목은 비어 있을 수 없습니다.")
    @field:Size(max = 100, message = "제목은 100자를 넘을 수 없습니다.")
    val title: String,

    @field:NotBlank(message = "내용은 비어 있을 수 없습니다.")
    val content: String
)