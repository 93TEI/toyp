package com.toyp.web.Dto;

import com.toyp.domain.Posts.Post;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsDto {

    private String title;
    private String author;
    private String content;

    @Builder
    public PostsDto(String title, String author, String content){
        this.title = title;
        this.author = author;
        this.content = content;
    }

    public Post toEntity(){
        return Post.builder()
                .title(title)
                .author(author)
                .content(content)
                .build();
    }
}
