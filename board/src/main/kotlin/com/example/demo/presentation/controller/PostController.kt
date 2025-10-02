package com.example.demo.presentation.controller

import com.example.demo.application.PostService
import com.example.demo.presentation.dto.request.PostRequestDto
import com.example.demo.presentation.dto.response.PostResponseDto

import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI

@RestController
@RequestMapping("/api/posts")
class PostController(
    private val postService: PostService
) {
    @PostMapping
    fun createPost(@Valid @RequestBody request: PostRequestDto): ResponseEntity<Void> {
        val postId = postService.createPost(request)
        // 생성된 리소스의 URI를 Location 헤더에 담아 201 Created 응답
        return ResponseEntity.created(URI.create("/api/posts/$postId")).build()
    }

    @GetMapping("/{id}")
    fun getPost(@PathVariable id: Long): ResponseEntity<PostResponseDto> {
        val postResponse = postService.getPost(id)
        return ResponseEntity.ok(postResponse)
    }

    @GetMapping
    fun getAllPosts(): ResponseEntity<List<PostResponseDto>> {
        val postResponses = postService.getAllPosts()
        return ResponseEntity.ok(postResponses)
    }

    @PutMapping("/{id}")
    fun updatePost(@PathVariable id: Long, @Valid @RequestBody request: PostRequestDto): ResponseEntity<Void> {
        postService.updatePost(id, request)
        return ResponseEntity.ok().build()
    }

    @DeleteMapping("/{id}")
    fun deletePost(@PathVariable id: Long): ResponseEntity<Void> {
        postService.deletePost(id)
        // 리소스가 성공적으로 삭제되었음을 알리는 204 No Content 응답
        return ResponseEntity.noContent().build()
    }
}