package com.toyp.web;

import com.toyp.config.EnumRole;
import com.toyp.domain.Posts.Member;
import com.toyp.domain.Posts.MemberRepository;
import com.toyp.service.LoginService;
import com.toyp.service.SecurityService;
import com.toyp.web.Dto.MemDto;
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
    private final LoginService ls;
    private final PasswordEncoder pe;
    private final MemberRepository mr;

    // 기본 id는 user, pw는 터미널에 뜨는 generated security password 넣으면 됨
    @GetMapping("/signin")
    public String SignIn(@RequestParam("name") String name, @RequestParam("pw") String pw){
        // 회원가입
        ls.MemberSave(name,pe.encode(pw));
        return (mr.findByNameMemEquals(name).get().getNameMem()+"님의 가입이 완료되었습니다.");
    }

    @GetMapping("/login")
    public String Login(@RequestParam("name") String name, @RequestParam("pw") String pw){

        //이름(id) 검증 후 pw 검증하여 둘 다 검증 통과하면 JWT token 발행
        String jwt = ls.Validation(name, pw);

        //jwt 멤버 디티오에 담아서 프론트로 넘기자
        MemDto validMem = new MemDto(name,pw, EnumRole.ROLE_USER,jwt);
        return  validMem.getNameMem() + "님의 검증이 완료되었습니다 ";

        //validation
    }
}


