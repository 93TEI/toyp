package com.toyp.service;

import com.toyp.domain.Posts.MemberRepository;
import com.toyp.web.Dto.MemberRequestDto;
import com.toyp.web.Dto.MemberResponseDto;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.security.SecurityUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository mr;

    @Transactional(readOnly = true)
    public MemberResponseDto getMemberInfo(String email){
        return mr.findByEmail(email)
                .map(MemberResponseDto::of)
                .orElseThrow(()-> new RuntimeException("유저 정보가 없습니다."));
    }

    @Transactional(readOnly = true)
    public MemberResponseDto getMyInfo(){
        return mr.findById(SecurityUtil.getCurMemId())
                .map(MemberResponseDto::of)
                .orElseThrow(()-> new RuntimeException("로그인된 유저 정보가 없습니다."));
    }
}
