package com.toyp.service;

import com.toyp.web.Dto.PostsDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

@Configuration
public class ServiceForDI {

    @Bean
    public PostsDto createDto(){
        return new PostsDto("service","0325tei","for DI");
    }
}
