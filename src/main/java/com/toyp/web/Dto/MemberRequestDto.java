package com.toyp.web.Dto;

import com.toyp.domain.Posts.Authority;
import com.toyp.domain.Posts.Member;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

@Getter
@RequiredArgsConstructor
public class MemberRequestDto {

    private final String email;
    private final String password;

    public Member toMember(PasswordEncoder pe){
        return Member.builder()
                .email(email)
                .password(password)
                .authority(Authority.ROLE_USER)
                .build();
    }

    public UsernamePasswordAuthenticationToken toAuthentication(){
        return new UsernamePasswordAuthenticationToken(email, password);
    }
}
