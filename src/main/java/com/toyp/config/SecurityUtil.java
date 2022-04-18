package com.toyp.config;

import lombok.NoArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@NoArgsConstructor
public class SecurityUtil {

    public static Long getCurMemId(){
        final Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if(auth == null || auth.getName() == null){
            throw new RuntimeException("Security Context에 인증 정보가 없습니다.");
        }

        return Long.parseLong(auth.getName());
    }
}
