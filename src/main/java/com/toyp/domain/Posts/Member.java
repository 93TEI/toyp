package com.toyp.domain.Posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_mb;

    @Column(nullable = false)
    private String name_mb;

    @Column(nullable = false)
    private String password;

    @Builder
    public Member(String name, String pw){
        this.name_mb = name;
        this.password = pw;
    }
}
