package com.example.demo.application.mapper;

import com.example.demo.domain.entity.Post;
import com.example.demo.presentation.dto.request.PostRequestDto;
import com.example.demo.presentation.dto.response.PostResponseDto;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-10-02T18:18:38+0900",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from kotlin-annotation-processing-gradle-1.9.25.jar, environment: Java 17.0.14 (Azul Systems, Inc.)"
)
@Component
public class PostMapperImpl implements PostMapper {

    @Override
    public Post toEntity(PostRequestDto request) {
        if ( request == null ) {
            return null;
        }

        String title = null;
        String content = null;

        title = request.getTitle();
        content = request.getContent();

        long id = 0L;

        Post post = new Post( id, title, content );

        return post;
    }

    @Override
    public PostResponseDto toResponseDto(Post post) {
        if ( post == null ) {
            return null;
        }

        long id = 0L;
        String title = null;
        String content = null;
        LocalDateTime createdAt = null;
        LocalDateTime updatedAt = null;

        id = post.getId();
        title = post.getTitle();
        content = post.getContent();
        createdAt = post.getCreatedAt();
        updatedAt = post.getUpdatedAt();

        PostResponseDto postResponseDto = new PostResponseDto( id, title, content, createdAt, updatedAt );

        return postResponseDto;
    }

    @Override
    public void updateFromDto(PostRequestDto dto, Post post) {
        if ( dto == null ) {
            return;
        }

        post.setTitle( dto.getTitle() );
        post.setContent( dto.getContent() );
    }
}
