package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository;

    //외부에서 넣어주도록
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    public Long join(Member member){

        /*
        //같은 이름이 있는 중복회원X
        Optional<Member> result = memberRepository.findByName(member.getName());
        //값이 있으면
        result.ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원");
        });
        */
        validateDuplicateMember(member);

        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                        .ifPresent(m -> {
                            throw new IllegalStateException("이미 존재하는 회원");
                        });
    }

    //전체 회원 조회 Service는 뭔가 비즈니스에 의존적으로
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}

