package com.example.demo.application.mapper;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H&J\u001a\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00052\b\b\u0001\u0010\b\u001a\u00020\u0003H'\u00a8\u0006\f"}, d2 = {"Lcom/example/demo/application/mapper/PostMapper;", "", "toEntity", "Lcom/example/demo/domain/entity/Post;", "request", "Lcom/example/demo/presentation/dto/request/PostRequestDto;", "toResponseDto", "Lcom/example/demo/presentation/dto/response/PostResponseDto;", "post", "updateFromDto", "", "dto", "demo"})
@org.mapstruct.Mapper(componentModel = "spring", unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public abstract interface PostMapper {
    
    @org.mapstruct.Mapping(target = "id", ignore = true)
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.demo.domain.entity.Post toEntity(@org.jetbrains.annotations.NotNull()
    com.example.demo.presentation.dto.request.PostRequestDto request);
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.demo.presentation.dto.response.PostResponseDto toResponseDto(@org.jetbrains.annotations.NotNull()
    com.example.demo.domain.entity.Post post);
    
    @org.mapstruct.Mapping(target = "id", ignore = true)
    public abstract void updateFromDto(@org.jetbrains.annotations.NotNull()
    com.example.demo.presentation.dto.request.PostRequestDto dto, @org.mapstruct.MappingTarget()
    @org.jetbrains.annotations.NotNull()
    com.example.demo.domain.entity.Post post);
}