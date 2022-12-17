package menu.controller;

import menu.model.Member;
import menu.model.MemberRepository;
import menu.model.MenuRepository;
import menu.model.RepositoryFactory;
import menu.view.ErrorMessage;
import menu.view.InputView;
import menu.view.Message;
import menu.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class InputCantEatController implements Controllable {
    private static final int MAX_CANT_EAT_COUNT = 2;

    private final InputView inputView;
    private final OutputView outputView;

    private final MemberRepository memberRepository;
    private final MenuRepository menuRepository;

    public InputCantEatController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        memberRepository = RepositoryFactory.getMemberRepository();
        menuRepository = RepositoryFactory.getMenuRepository();
    }

    @Override
    public void execute() {
        memberRepository.getAll()
                .forEach(member -> {
                    outputView.printFormatMessage(Message.REQUEST_CANT_EAT, member.getName());
                    List<String> menu = inputView.createMenu();
                    validateMenuCount(menu);
                    setCanEats(member, menu);
                });
        ControllerFactory.get(ControllerType.RECOMMEND_RESULT).execute();
    }

    private void setCanEats(Member member, List<String> menu) {
        member.setCantEat(
                menu.stream()
                        .map(menuRepository::findByName)
                        .collect(Collectors.toList()));
    }

    private void validateMenuCount(List<String> menu) {
        if(menu.size() > MAX_CANT_EAT_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.OUT_OF_RANGE_CANT_EAT.getMessage());
        }
    }
}
