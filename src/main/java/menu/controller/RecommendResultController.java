package menu.controller;

import menu.model.MemberRepository;
import menu.model.MenuCategory;
import menu.model.RepositoryFactory;
import menu.service.RecommendService;
import menu.view.Message;
import menu.view.OutputView;

import java.util.List;

public class RecommendResultController implements Controllable {
    private final OutputView outputView;
    private final RecommendService recommendService;
    private final MemberRepository memberRepository;

    public RecommendResultController(OutputView outputView) {
        this.outputView = outputView;
        recommendService = new RecommendService();
        memberRepository = RepositoryFactory.getMemberRepository();
    }

    @Override
    public void execute() {
        outputView.printMessage(Message.RESPONSE_RECOMMEND);
        List<MenuCategory> menuCategories = recommendService.recommend();
        outputView.printHeader();
        outputView.printCategory(menuCategories);
        memberRepository.getAll().forEach(outputView::printRecommend);
        ControllerFactory.get(ControllerType.EXIT).execute();
    }
}
