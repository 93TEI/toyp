package com.toyp.web;

import com.toyp.service.PostsService;
import com.toyp.service.ServiceForDI;
import com.toyp.web.Dto.PostsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
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
        ApplicationContext context = new AnnotationConfigApplicationContext(ServiceForDI.class);
        ps.save(context.getBean("createDto",PostsDto.class));
        return Arrays.asList("Arrays.asList","Hello");
    }

    @GetMapping("/post")
    public Long save(){
        PostsDto temp = new PostsDto("this is title","im author","content!");
        return ps.save(temp);
    }
}