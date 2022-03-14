package com.toyp.service;

import com.toyp.domain.Posts.PostRepository;
import com.toyp.web.Dto.PostsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostRepository pr;

    @Transactional
    public Long save(PostsDto requestDto){
        return pr.save(requestDto.toEntity()).getId();
    }
}
