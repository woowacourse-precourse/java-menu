package menu;

import menu.controller.CoachController;
import menu.controller.FrontController;
import menu.controller.MenuController;
import menu.domain.coach.repository.CoachRepository;
import menu.domain.menu.repository.MenuRepository;
import menu.service.coach.CoachService;
import menu.service.menu.MenuService;
import menu.view.coach.CoachInputView;
import menu.view.coach.CoachOutputView;
import menu.view.front.FrontOutputView;
import menu.view.menu.MenuOutputView;

public class ApplicationConfig {

    private final MenuRepository menuRepository;
    private final CoachRepository coachRepository;

    public ApplicationConfig() {
        MenuRepositoryInitializer menuRepositoryInitializer = new MenuRepositoryInitializer();
        this.menuRepository = menuRepositoryInitializer.getMenuRepository();
        this.coachRepository = new CoachRepository();
    }

    public FrontController initFrontController() {
        return new FrontController(initCoachController(), initMenuController(), FrontOutputView.getInstance());
    }

    private MenuController initMenuController() {
        return new MenuController(initMenuService(), MenuOutputView.getInstance());
    }

    private MenuService initMenuService() {
        return new MenuService(coachRepository, menuRepository);
    }

    private CoachController initCoachController() {
        return new CoachController(initCoachService(),
                CoachInputView.getInstance(), CoachOutputView.getInstance());
    }

    private CoachService initCoachService() {
        return new CoachService(coachRepository, menuRepository);
    }
}
