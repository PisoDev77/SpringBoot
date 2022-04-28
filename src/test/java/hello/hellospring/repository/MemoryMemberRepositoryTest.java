package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

//class 레벨에서 돌리면 다 됨
class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    //끝날때마다 호출됨 테스트 단위로?
    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }


    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");
        
        repository.save(member);
        
        //Optional에서 꺼낼 때 get 하는데 사실 좋은거 아님 테스트니까 그냥
        Member result = repository.findById(member.getId()).get();

        // 그런데 글자로 계속 볼 수없자나 assert라는 기능있음

        // 녹색뜨면 성공 아니면 빨강 뜸
        //Assertions.assertEquals(member, result);

        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }
    
    /*
    * 뭐가 먼저 실행 될지 몰라 
    * 이미 저장된 값때문에 실패됨
    * 그래서 테스트 끝나면 데이터를 클린해줘야해\
    * 요게 테스트케이스
    * 
    * 순서를 뒤집는거 테스트 먼저하고 틀을 먼저 만드는거 테스트주도개발 TDD 오호 이제
    * 조금 안듯
    *
    * 테스트가 수십수백개면 ?
    * */
}
