package com.toyp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RequestMapping("/security")
@RestController
public class SecurityController {
    @Autowired
    private SecurityService ss;

    // 기본 id는 user, pw는 터미널에 뜨는 generated security password 넣으면 됨
    @GetMapping("/create/token")
    public Map<String, Object> createToken(@RequestParam(value = "subject") String subject){
        System.out.println("sss");
        String token = ss.createToken(subject,(2*1000*60)); // 만료시간 : 2분
        Map<String,Object> map = new LinkedHashMap<>();
        map.put("result",token);
        System.out.println("sss");
        return map;
    }

    @GetMapping("/get/subject")
    public Map<String,Object> getSubject(@RequestParam(value = "token") String token){
        String subject = ss.getSubject(token);
        Map<String,Object> map = new LinkedHashMap<>();
        map.put("result",subject);
        return map;
    }
}
