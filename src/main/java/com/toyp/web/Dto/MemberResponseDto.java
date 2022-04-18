package com.toyp.web.Dto;

import com.toyp.domain.Posts.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MemberResponseDto {
    private String email; // 없어도 될 거 같은데 없으면 오류뜸
    public static MemberResponseDto of(Member member){
        return new MemberResponseDto(member.getEmail());
    }
}
