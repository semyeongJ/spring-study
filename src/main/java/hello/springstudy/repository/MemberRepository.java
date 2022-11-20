package hello.springstudy.repository;

import hello.springstudy.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id); // optional 은 결과 없으면 null 처리
    Optional<Member> findByName(String name);
    List<Member> findAll();
}