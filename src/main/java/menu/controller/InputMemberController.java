package menu.controller;

import menu.model.Member;
import menu.model.MemberRepository;
import menu.model.RepositoryFactory;
import menu.view.ErrorMessage;
import menu.view.InputView;
import menu.view.Message;
import menu.view.OutputView;

import java.util.List;

public class InputMemberController implements Controllable{
    private final InputView inputView;
    private final OutputView outputView;

    private final MemberRepository memberRepository;

    public InputMemberController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        memberRepository = RepositoryFactory.getMemberRepository();
    }

    @Override
    public void execute() {
        outputView.printMessage(Message.REQUEST_MEMBER_NAME);
        List<Member> member = inputView.createMember();
        validateMemberCount(member);
        memberRepository.addMembers(member);
        ControllerFactory.get(ControllerType.INPUT_CANT_EAT).execute();
    }

    private void validateMemberCount(List<Member> member) {
        if(member.size() < 2 || member.size() > 5) {
            throw new IllegalArgumentException(ErrorMessage.OUT_OF_RANGE_MEMBER.getMessage());
        }
    }

}
