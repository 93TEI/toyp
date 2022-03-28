package com.toyp.service;

import com.toyp.web.Dto.PostsDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

@Configuration
//@Service
public class ServiceForDI {

    //@Bean은 메소드에서 반환되는 객체를 Bean으로 만들고
    //@Component는 클래스를 Bean으로 만든다
    @Bean
    public PostsDto createDto(){
        return new PostsDto("service","0325tei","for DI");
    }
}
