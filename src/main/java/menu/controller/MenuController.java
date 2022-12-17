package menu.controller;

import menu.domain.Category;
import menu.domain.CategoryHistory;
import menu.domain.Coach;
import menu.domain.Coaches;
import menu.service.CategoryService;
import menu.service.MenuService;
import menu.util.Constant;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {
    private static final int MONDAY = 1;
    private static final int FRIDAY = 5;

    private InputView inputView;
    private OutputView outputView;
    private CategoryHistory categoryHistory;
    private CategoryService categoryService;
    private MenuService menuService;
    private Coaches coaches;

    public MenuController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.categoryHistory = new CategoryHistory();
        this.categoryService = new CategoryService(categoryHistory);
        this.menuService = new MenuService();
        this.coaches = new Coaches();
    }

    public void startMenuRecommendService() {
        outputView.printServiceStartNotice();

        readCoachNames();

        readDislikeFoods();

        for (int day = MONDAY; day <= FRIDAY; day++) {
            recommendCategoryAndMenu();
        }

        outputView.printServiceEndNotice(categoryHistory.getCategoryHistory(), coaches.getCoaches());
    }

    private void readCoachNames() {
        outputView.printCoachNameInputNotice();
        String coachNameInput = inputView.readCoachNames();

        String[] coachNames = coachNameInput.split(Constant.INPUT_DELIMITER);

        for (String name : coachNames) {
            coaches.addCoach(new Coach(name));
        }
    }

    private void readDislikeFoods() {
        for (Coach coach : coaches.getCoaches()) {
            outputView.printDislikeFoodInputNotice(coach.getName());
            coach.addDislikeFood(inputView.readDislikeFoods());
        }
    }

    private void recommendCategoryAndMenu() {
        Category category = recommendCategory();

        for (Coach coach : coaches.getCoaches()) {
            recommendMenu(coach, category);
        }
    }

    private Category recommendCategory() {
        Category category = categoryService.selectCategory();
        categoryHistory.addCategory(category);

        return category;
    }

    private void recommendMenu(Coach coach, Category category) {
        String menu = menuService.selectMenu(coach, category);
        coach.addRecommendedMenu(menu);
    }
}
