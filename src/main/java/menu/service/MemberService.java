package menu.service;

import menu.domain.Member;
import menu.repo.MemberRepository;

import java.util.List;

public class MemberService {
    private final MemberRepository memberRepository = MemberRepository.getInstance();

    public void saveMember(Member member) {
        memberRepository.save(member);
    }

    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    public List<String> findWeekEatAllByName(String name) {
        return memberRepository.findWeekEatAllByName(name);
    }

    public List<String> findNotEatAllByName(String name) {
        return memberRepository.findNotEatAllByName(name);
    }
}
