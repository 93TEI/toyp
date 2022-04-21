package com.toyp.service;

import com.toyp.config.EnumRole;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static com.toyp.config.EnumRole.ROLE_USER;

@Service
public class SecurityService {

    private final String SECRET_KEY;

    public SecurityService(@Value("${jwt.secret}") String key){
        this.SECRET_KEY = key;
    }

    public String createToken(String name, long expTime){
        if(expTime <=0){
            throw new RuntimeException("만료시간이 0보다 작다");
        }
        // 서명 알고리즘 선택
        SignatureAlgorithm sa = SignatureAlgorithm.HS256;
        byte[] secretKeyBytes = Decoders.BASE64.decode(SECRET_KEY);

        // 키 생성
        Key signingKey = new SecretKeySpec(secretKeyBytes,sa.getJcaName());

        // payload 추가
        Map<String, Object> payload = new HashMap<>();
        payload.put("name",name);
        payload.put("role",ROLE_USER);

        //만든 키 리턴
        return Jwts.builder()
                .setClaims(payload)
                .setExpiration(new Date(System.currentTimeMillis() + expTime))
                .signWith(signingKey,sa) // header "alg" = HS256
                .compact(); // String 형태로 만들어짐
    }

    public String getSubject(String token){
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(Decoders.BASE64.decode(SECRET_KEY))
                .build()
                .parseClaimsJws(token) // token을 넣어서 풀어주기
                .getBody();          // 클레임이 만들어짐 (클레임에는 페이로드 안에 여러 정보를 넣을 수 있음)
        return claims.toString(); // claims.get("name")으로 원하는 항목만 뽑기 가능
    }
}
