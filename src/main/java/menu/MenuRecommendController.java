package menu;

import java.util.List;
import menu.domain.coach.Coach;
import menu.domain.coach.Coaches;
import menu.domain.menu.MenuService;
import menu.domain.results.RecommendResult;
import menu.ui.dto.CoachesRequest;
import menu.ui.dto.MenuRequest;
import menu.ui.view.InputView;
import menu.ui.view.OutputView;

public class MenuRecommendController {
    private final InputView inputView;
    private final OutputView outputView;
    private final MenuService menuService;

    public MenuRecommendController(InputView inputView, OutputView outputView,
                                   MenuService menuService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.menuService = menuService;
    }

    public void init() {
        outputView.onBoardingPage();
    }

    public void run() {
        Coaches coaches = requestCoachNames();
        requestCoachesAvoidMenu(coaches);

        RecommendResult recommendResult = menuService.recommendMenus(coaches);
        outputView.resultView(recommendResult);
    }

    private Coaches requestCoachNames() {
        try {
            CoachesRequest coachesRequest = inputView.requestCoachNames();
            return coachesRequest.toCoaches();
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception.getMessage());
            return requestCoachNames();
        }
    }

    private void requestCoachesAvoidMenu(Coaches coaches) {
        for (Coach coach : coaches.getCoaches()) {
            requestAvoidMenu(coach);
        }
    }

    private void requestAvoidMenu(Coach coach) {
        try {
            MenuRequest coachAvoidMenu = inputView.getCoachAvoidMenu(coach.getName());
            List<String> menuNames = coachAvoidMenu.getMenus();
            menuService.addCoachAvoidMenu(coach, menuNames);
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception.getMessage());
            requestAvoidMenu(coach);
        }
    }


}
