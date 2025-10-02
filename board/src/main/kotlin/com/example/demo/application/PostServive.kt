package com.example.demo.application

import com.example.demo.domain.repository.PostRepository
import org.springframework.stereotype.Service

@Service
@Constructor
class PostServive {
    private val postRepository : PostRepository
}