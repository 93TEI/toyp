package com.toyp.web;

import com.toyp.service.PostsService;
import com.toyp.web.Dto.PostsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class MainController {

    private final PostsService ps;

    @GetMapping("/home")
    public List<String> home(){
        return Arrays.asList("안녕하세요","Hello");
    }

    @GetMapping("/post")
    public Long save(){
        PostsDto temp = new PostsDto("this is title","im author","content!");
        return ps.save(temp);
    }
}