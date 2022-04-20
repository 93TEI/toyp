package com.toyp.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;

@Service
public class SecurityService {

    private final String SECRET_KEY;

    public SecurityService(@Value("${jwt.secret}") String key){
        this.SECRET_KEY = key;
    }

    public String createToken(String name, long expTime){
        if(expTime <=0){
            throw new RuntimeException("만료시간 다 됐음");
        }
        // 서명 알고리즘 선택
        SignatureAlgorithm sa = SignatureAlgorithm.HS256;
        byte[] secretKeyBytes = Decoders.BASE64.decode(SECRET_KEY);
        Key signingKey = new SecretKeySpec(secretKeyBytes,sa.getJcaName()); // 키가 만들어짐
        //만든 키 리턴
        return Jwts.builder()
                .setSubject(name)
                .signWith(signingKey,sa)
                .setExpiration(new Date(System.currentTimeMillis() + expTime))
                .compact(); // String 형태로 만들어짐
    }

    public String getSubject(String token){
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(Decoders.BASE64.decode(SECRET_KEY))
                .build()
                .parseClaimsJws(token) // token을 넣어서 풀어주기
                .getBody();          // 클레임이 만들어짐 (클레임에는 페이로드 안에 여러 정보를 넣을 수 있음)
        return claims.getSubject();
    }
}
