package com.example.demo.application

import com.example.demo.application.mapper.PostMapper
import com.example.demo.domain.repository.PostRepository
import com.example.demo.presentation.dto.request.PostRequestDto
import com.example.demo.presentation.dto.response.PostResponseDto

import jakarta.persistence.EntityNotFoundException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PostService(
    private val postRepository: PostRepository,
    private val postMapper: PostMapper
) {
    @Transactional
    fun createPost(request: PostRequestDto): Long {
        val newPost = postMapper.toEntity(request) // (수정) 매퍼 사용
        return postRepository.save(newPost).id
    }

    @Transactional(readOnly = true)
    fun getPost(id: Long): PostResponseDto {
        val post = postRepository.findByIdOrNull(id)
            ?: throw EntityNotFoundException("게시글을 찾을 수 없습니다. id: $id")
        return postMapper.toResponseDto(post) // (수정) 매퍼 사용
    }

    @Transactional(readOnly = true)
    fun getAllPosts(): List<PostResponseDto> {
        return postRepository.findAll().map { postMapper.toResponseDto(it) } // (수정) 매퍼 사용
    }

    @Transactional
    fun updatePost(id: Long, request: PostRequestDto) {
        val post = postRepository.findByIdOrNull(id)
            ?: throw EntityNotFoundException("게시글을 찾을 수 없습니다. id: $id")

        postMapper.updateFromDto(request, post) // (수정) 매퍼의 업데이트 기능 사용
    }

    @Transactional
    fun deletePost(id: Long) {
        if (!postRepository.existsById(id)) {
            throw EntityNotFoundException("게시글을 찾을 수 없습니다. id: $id")
        }
        postRepository.deleteById(id)
    }
}