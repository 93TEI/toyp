package com.toyp.web;

import com.toyp.service.PostService;
import com.toyp.service.ServiceForDI;
import com.toyp.web.Dto.PostsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostController {

    private final PostService ps;

    @GetMapping("/home")
    public List<String> home(){
        //ApplicationContext,@Configuration,@Bean을 사용한 DI. 이거 없이 걍 넣으면 DI 못해서 널포인트익셉션 뜸
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