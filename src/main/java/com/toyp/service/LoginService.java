package com.toyp.service;

import com.toyp.config.EnumRole;
import com.toyp.domain.Posts.Member;
import com.toyp.domain.Posts.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class LoginService {
    private final MemberRepository mr;

    @Transactional
    public String MemberSave(String name, String pw){
        mr.save(Member.builder()
                .name(name)
                .pw(pw)
                .role(EnumRole.ROLE_USER)
                .build());
        return "s";
    }

    // findByEmail로 비번 get해서 검증 -> if문 처리로 아닐 때 exception, 맞을 때 토큰 발행
    @Transactional
    public String ValidationPassword(String name, String pw){
        return "s";
    }

}
