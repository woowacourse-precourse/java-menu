package menu;

import menu.domain.coach.Coaches;
import menu.domain.menu.MenuRecommendService;
import menu.ui.dto.CoachesRequest;
import menu.ui.view.InputView;
import menu.ui.view.OutputView;

public class MenuRecommendController {
    private final InputView inputView;
    private final OutputView outputView;
    private final MenuRecommendService menuRecommendService;

    public MenuRecommendController(InputView inputView, OutputView outputView, MenuRecommendService menuRecommendService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.menuRecommendService = menuRecommendService;
    }

    public void init() {
        outputView.onBoardingPage();
    }
    public void run() {
        CoachesRequest coachesRequest = inputView.requestCoachNames();
        Coaches coaches = coachesRequest.toCoaches();
    }


}
