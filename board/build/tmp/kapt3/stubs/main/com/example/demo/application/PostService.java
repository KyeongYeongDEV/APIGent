package com.example.demo.application;

@org.springframework.stereotype.Service()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0017\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0017J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0017J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0017J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\bH\u0017J\u0018\u0010\u0012\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/example/demo/application/PostService;", "", "postRepository", "Lcom/example/demo/domain/repository/PostRepository;", "postMapper", "Lcom/example/demo/application/mapper/PostMapper;", "(Lcom/example/demo/domain/repository/PostRepository;Lcom/example/demo/application/mapper/PostMapper;)V", "createPost", "", "request", "Lcom/example/demo/presentation/dto/request/PostRequestDto;", "deletePost", "", "id", "getAllPosts", "", "Lcom/example/demo/presentation/dto/response/PostResponseDto;", "getPost", "updatePost", "demo"})
public class PostService {
    @org.jetbrains.annotations.NotNull()
    private final com.example.demo.domain.repository.PostRepository postRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.demo.application.mapper.PostMapper postMapper = null;
    
    public PostService(@org.jetbrains.annotations.NotNull()
    com.example.demo.domain.repository.PostRepository postRepository, @org.jetbrains.annotations.NotNull()
    com.example.demo.application.mapper.PostMapper postMapper) {
        super();
    }
    
    @org.springframework.transaction.annotation.Transactional()
    public long createPost(@org.jetbrains.annotations.NotNull()
    com.example.demo.presentation.dto.request.PostRequestDto request) {
        return 0L;
    }
    
    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    @org.jetbrains.annotations.NotNull()
    public com.example.demo.presentation.dto.response.PostResponseDto getPost(long id) {
        return null;
    }
    
    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    @org.jetbrains.annotations.NotNull()
    public java.util.List<com.example.demo.presentation.dto.response.PostResponseDto> getAllPosts() {
        return null;
    }
    
    @org.springframework.transaction.annotation.Transactional()
    public void updatePost(long id, @org.jetbrains.annotations.NotNull()
    com.example.demo.presentation.dto.request.PostRequestDto request) {
    }
    
    @org.springframework.transaction.annotation.Transactional()
    public void deletePost(long id) {
    }
}