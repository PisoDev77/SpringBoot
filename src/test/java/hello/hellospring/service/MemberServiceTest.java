package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

//ctrl shift t 테스트 자동 생성
class MemberServiceTest {

    /*
    *   테스트는 과감하게 한글로 바꾸셔도 됩니다.
    *   실제 동작코드는 한글로 적기 애매한데
    *   테스트는 아주 좋음
    * */

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    /*
    * 조금 애매한게 있어요 
    * 다른 객체란 말이에요. 각 테스트 memorymeberreop가 다른 객체 쓸 이유가 없잖아요
    * 그래서 바꾸자
    * 테스트 메인이 다른 그거임 다른 레포를 이용
    * 같은걸로 테스트해야대
    * */
    //요런게 DI
    @BeforeEach
    public void beforeEach(){
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }
    @AfterEach
    public void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    void 회원가입() {
        //given 상황이 주어졌을때
        Member member = new Member();
        member.setName("김영한");

        //when 이걸 검증
        Long saveId = memberService.join(member);

        //then 이런 결과가 나와야해
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복회원예외(){
        //given
        Member member1 = new Member();
        member1.setName("김영한");

        Member member2 = new Member();
        member2.setName("김영한");

        //when
        memberService.join(member1);
        //여기서 이게 터저야되
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원");
        /*
        try{
            memberService.join(member2);
            fail();
        }catch (IllegalStateException e) {
            assertThat(e.getMessage()).isEqualTo("aa");
        }
        //좀 애매함
         */


        //then
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}