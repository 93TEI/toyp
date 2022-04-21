package com.toyp.web;

import com.toyp.domain.Posts.Member;
import com.toyp.domain.Posts.MemberRepository;
import com.toyp.service.SecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class SecurityController {

    private final SecurityService ss;
    private final MemberRepository mr;
    private final PasswordEncoder pe;

    // 기본 id는 user, pw는 터미널에 뜨는 generated security password 넣으면 됨
    @GetMapping("/signin")
    public Map<String, Object> createToken(@RequestParam("name") String name,@RequestParam("pw") String pw){
        // 저장 후 토큰 생성
        mr.save(new Member(name,pe.encode(pw)));
        String token = ss.createToken(name,(2*1000*60)); // 만료시간 : 2분
        Map<String,Object> map = new LinkedHashMap<>();
        map.put("result",token);
        return map;
    }

    @GetMapping("/login")
    public Map<String,Object> getSubject(@RequestParam("token") String token){
        String subject = ss.getSubject(token);
        Map<String,Object> map = new LinkedHashMap<>();
        map.put("result",subject);
        return map;
    }
}


