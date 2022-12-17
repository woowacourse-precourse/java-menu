package container;

import menu.controller.MenuRecommendController;
import menu.service.CoachService;
import menu.service.MenuRecommendService;
import menu.service.NotEatFoodService;

public class SystemContainer {

    private static final SystemContainer INSTANCE = new SystemContainer();

    private SystemContainer() {

    }

    public static SystemContainer getInstance() {
        return INSTANCE;
    }

    public MenuRecommendController menuRecommendController() {
        return new MenuRecommendController(coachService(), menuRecommendService(), notEatFoodService());
    }

    public CoachService coachService() {
        return new CoachService();
    }

    public MenuRecommendService menuRecommendService() {
        return new MenuRecommendService();
    }

    public NotEatFoodService notEatFoodService() {
        return new NotEatFoodService();
    }

}
