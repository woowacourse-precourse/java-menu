package menu.repo;

import menu.domain.Member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberRepository {
    private Long id = 0L;
    private final Map<Long, Member> members = new HashMap<>();
    private static MemberRepository memberRepository = new MemberRepository();

    private MemberRepository(){
    }

    public static MemberRepository getInstance() {
        return memberRepository;
    }

    public Long save(Member member) {
        members.put(id, member);
        return id++;
    }

    public Member findById(Long id) {
        return members.get(id);
    }

    public List<Member> findAll() {
        return new ArrayList<>(members.values());
    }

    public List<String> findNotEatAllByName(String name) {
        Member member = findByName(name);
        return member.getNotEat();
    }

    public List<String> findWeekEatAllByName(String name) {
        Member member = findByName(name);
        return member.getWeekEat();
    }

    private Member findByName(String name) {
        Member member = members.values().stream()
                .filter(o -> o.getName().equals(name))
                .findFirst().orElse(null);
        return member;
    }

}
