package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

//@Repository
public class MemoryMemberRepository implements MemberRepository{

    //실무에서는 동시성문제때문에 Hashmap 잘안써
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 8L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.of(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        //람다를 쓸께요?
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>((store.values()));
    }

    public void clearStore() {
        store.clear();
    }
}


/*\
* 동작하는지 확인하는 거 테스트케이스 작성하는것 !!!!!!
* 코드를 코드로 검증
* 메인메소드로 돌려봐야지 너무 오래걸려 반복적으로 실행하기 어려웡 그래서 Junit 이용합니다.
*
*
* */