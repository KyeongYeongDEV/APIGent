package com.example.demo.application.mapper

import com.example.demo.domain.entity.Post
import com.example.demo.presentation.dto.request.PostRequestDto
import com.example.demo.presentation.dto.response.PostResponseDto

import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.MappingTarget
import org.mapstruct.ReportingPolicy


@Mapper(
    componentModel = "spring",
    unmappedTargetPolicy = ReportingPolicy.IGNORE
)
interface PostMapper {
    @Mapping(target = "id", ignore = true)
    fun toEntity(request : PostRequestDto) : Post

    fun toResponseDto(post : Post) : PostResponseDto

    @Mapping(target = "id", ignore = true)
    fun updateFromDto(dto : PostRequestDto, @MappingTarget post : Post)
}