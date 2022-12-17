package menu;

import menu.domain.CategoryRepository;
import menu.service.CategoryService;
import menu.service.CoachService;
import menu.service.FoodService;
import menu.service.MenuService;

public class MenuController {
    private final MenuService menuService = new MenuService();
    private final CoachService coachService = new CoachService();
    private final CategoryService categoryService = new CategoryService();
    private final FoodService foodService = new FoodService();

    public void run() {
        initRoutine();
        mainRoutine();
        exitRoutine();
    }

    private void initRoutine() {
        menuService.printServiceStart();

        String[] coaches = menuService.askCoachNames();
        coachService.initialize(coaches);

        for (String coach : coaches) {
            String[] foods = menuService.askInedibleFoodName(coach);
            coachService.addInedibleFood(coach, foods);
        }

        categoryService.initialize();
    }

    private void mainRoutine() {
        foodService.initialize();
    }

    private void exitRoutine() {
        menuService.printServiceExit();
    }
}
