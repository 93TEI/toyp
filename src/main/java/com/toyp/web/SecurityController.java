package com.toyp.web;

import com.toyp.service.SecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class SecurityController {

    private final SecurityService ss;

    // 기본 id는 user, pw는 터미널에 뜨는 generated security password 넣으면 됨
    @GetMapping("/signin")
    public Map<String, Object> createToken(@RequestParam(value = "name") String subject){
        String token = ss.createToken(subject,(2*1000*60)); // 만료시간 : 2분
        Map<String,Object> map = new LinkedHashMap<>();
        map.put("result",token);
        return map;
    }

    @GetMapping("/login")
    public Map<String,Object> getSubject(@RequestParam(value = "token") String token){
        String subject = ss.getSubject(token);
        Map<String,Object> map = new LinkedHashMap<>();
        map.put("result",subject);
        return map;
    }
}


