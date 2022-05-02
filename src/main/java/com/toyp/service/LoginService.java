package com.toyp.service;

import com.toyp.config.EnumRole;
import com.toyp.domain.Posts.Member;
import com.toyp.domain.Posts.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class LoginService {
    private final MemberRepository mr;
    // 변수를 만들어서 사용해야 함
    private final PasswordEncoder pe;

    private final SecurityService ss;

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
    public String Validation(String name, String pw) throws UsernameNotFoundException {

        // name 검증
        String pwFromDB = mr.findByNameMemEquals(name)
                                .orElseThrow(()-> new UsernameNotFoundException("그런 사용자는 없습니다."))
                                .getPassword();

        // password 검증
        if(!pe.matches(pw, pwFromDB)){
            return new UsernameNotFoundException("비밀번호가 다릅니다").toString(); // throw가 제대로 되는지는 모르겠음
        } else{
            return ss.createToken(mr.findByNameMemEquals(name).get().getNameMem(),1000 * 60 *5);
        }
    }

}
