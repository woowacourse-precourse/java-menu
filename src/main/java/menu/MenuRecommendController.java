package menu;

import java.util.List;
import menu.domain.coach.Coach;
import menu.domain.coach.Coaches;
import menu.domain.menu.MenuService;
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
        CoachesRequest coachesRequest = inputView.requestCoachNames();
        Coaches coaches = coachesRequest.toCoaches();
        updateCoachesAvoidMenu(coaches);
    }

    private void updateCoachesAvoidMenu(Coaches coaches) {
        for (Coach coach : coaches.getCoaches()) {
            MenuRequest coachAvoidMenu = inputView.getCoachAvoidMenu(coach.getName());
            List<String> menuNames = coachAvoidMenu.getMenus();
            menuService.addCoachAvoidMenu(coach, menuNames);
        }
    }


}
