package menu;

import menu.domain.menu.MenuRecommendService;
import menu.ui.view.InputView;
import menu.ui.view.ResultView;

public class MenuRecommendController {
    private final InputView inputView;
    private final ResultView resultView;
    private final MenuRecommendService menuRecommendService;

    public MenuRecommendController(InputView inputView, ResultView resultView, MenuRecommendService menuRecommendService) {
        this.inputView = inputView;
        this.resultView = resultView;
        this.menuRecommendService = menuRecommendService;
    }

    public void init() {
        inputView.onBoardingPage();
    }
    public void run() {
    }


}
