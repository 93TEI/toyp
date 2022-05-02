package com.toyp.domain.Posts;

import com.toyp.config.EnumRole;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity(name = "Member")
public class Member {
    // 언더바 절 대 쓰 지 말 것!!! -> 쓰면 JPA의 메소드 규칙에 어긋나서 못찾음
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_mb;

    @NonNull
    private String nameMem;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private EnumRole role;

    private String jwt;


    @Builder
    public Member(String name, String pw, EnumRole role, String jwt){
        this.nameMem = name;
        this.password = pw;
        this.role = role;
        this.jwt = jwt;
    }
}
