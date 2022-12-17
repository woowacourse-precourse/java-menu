package menu.controller;

import menu.domain.Member;
import menu.repo.MemberRepository;
import menu.utils.MemberValid;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.Arrays;

public class Controller {
    private final MemberRepository memberRepository = new MemberRepository();

    public void run() {
        OutputView.printStart();
        saveMember();
    }

    private void saveMember() {
        String[] members = InputView.inputMember().split(",");
        MemberValid.isValidMember(members);
        for (String member : members) {
            String[] notEats = InputView.inputNotEat(member).split(",");
            MemberValid.isValidNotEat(notEats);
            memberRepository.save(new Member(member, Arrays.asList(notEats)));
        }
    }
}
