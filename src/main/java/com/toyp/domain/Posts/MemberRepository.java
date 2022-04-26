package com.toyp.domain.Posts;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    // Optional로 리턴해야 orElseThrow가 가능해짐
    Optional<Member> findByNameMemEquals(String name_mb);
}
