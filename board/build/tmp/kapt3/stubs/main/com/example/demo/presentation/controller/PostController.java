package com.example.demo.presentation.controller;

@org.springframework.web.bind.annotation.RestController()
@org.springframework.web.bind.annotation.RequestMapping(value = {"/api/posts"})
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0017\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0001\u0010\b\u001a\u00020\tH\u0017J\u0018\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0001\u0010\u000b\u001a\u00020\fH\u0017J\u0014\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\u0006H\u0017J\u0018\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00062\b\b\u0001\u0010\u000b\u001a\u00020\fH\u0017J\"\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0001\u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010\b\u001a\u00020\tH\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/example/demo/presentation/controller/PostController;", "", "postService", "Lcom/example/demo/application/PostService;", "(Lcom/example/demo/application/PostService;)V", "createPost", "Lorg/springframework/http/ResponseEntity;", "Ljava/lang/Void;", "request", "Lcom/example/demo/presentation/dto/request/PostRequestDto;", "deletePost", "id", "", "getAllPosts", "", "Lcom/example/demo/presentation/dto/response/PostResponseDto;", "getPost", "updatePost", "demo"})
public class PostController {
    @org.jetbrains.annotations.NotNull()
    private final com.example.demo.application.PostService postService = null;
    
    public PostController(@org.jetbrains.annotations.NotNull()
    com.example.demo.application.PostService postService) {
        super();
    }
    
    @org.springframework.web.bind.annotation.PostMapping()
    @org.jetbrains.annotations.NotNull()
    public org.springframework.http.ResponseEntity<java.lang.Void> createPost(@jakarta.validation.Valid()
    @org.springframework.web.bind.annotation.RequestBody()
    @org.jetbrains.annotations.NotNull()
    com.example.demo.presentation.dto.request.PostRequestDto request) {
        return null;
    }
    
    @org.springframework.web.bind.annotation.GetMapping(value = {"/{id}"})
    @org.jetbrains.annotations.NotNull()
    public org.springframework.http.ResponseEntity<com.example.demo.presentation.dto.response.PostResponseDto> getPost(@org.springframework.web.bind.annotation.PathVariable()
    long id) {
        return null;
    }
    
    @org.springframework.web.bind.annotation.GetMapping()
    @org.jetbrains.annotations.NotNull()
    public org.springframework.http.ResponseEntity<java.util.List<com.example.demo.presentation.dto.response.PostResponseDto>> getAllPosts() {
        return null;
    }
    
    @org.springframework.web.bind.annotation.PutMapping(value = {"/{id}"})
    @org.jetbrains.annotations.NotNull()
    public org.springframework.http.ResponseEntity<java.lang.Void> updatePost(@org.springframework.web.bind.annotation.PathVariable()
    long id, @jakarta.validation.Valid()
    @org.springframework.web.bind.annotation.RequestBody()
    @org.jetbrains.annotations.NotNull()
    com.example.demo.presentation.dto.request.PostRequestDto request) {
        return null;
    }
    
    @org.springframework.web.bind.annotation.DeleteMapping(value = {"/{id}"})
    @org.jetbrains.annotations.NotNull()
    public org.springframework.http.ResponseEntity<java.lang.Void> deletePost(@org.springframework.web.bind.annotation.PathVariable()
    long id) {
        return null;
    }
}