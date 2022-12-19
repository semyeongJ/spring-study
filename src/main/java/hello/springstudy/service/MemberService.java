package hello.springstudy.service;

import hello.springstudy.domain.Member;
import hello.springstudy.repository.MemberRepository;
import hello.springstudy.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemoryMemberRepository memberRepository) {     // DI (Dependency Injection)
        this.memberRepository = memberRepository;
    }

    /* 회원가입 */
    public Long join(Member member){
        validateDuplicateMember(member);    // 중복회원 검증
        memberRepository.save(member);
        return  member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName()) //ctrl+alt+v
                .ifPresent(m -> { //result가 null이 아니면 즉, 값이 있으면 동작
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /* 전체 회원 조회 */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }

}