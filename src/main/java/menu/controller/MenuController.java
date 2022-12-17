package menu.controller;

import java.util.List;
import menu.domain.Category;
import menu.domain.CategoryHistory;
import menu.domain.Coach;
import menu.domain.Menu;
import menu.service.CategoryService;
import menu.service.MenuService;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {

    private InputView inputView;
    private OutputView outputView;
    private CategoryHistory categoryHistory;
    private CategoryService categoryService;
    private MenuService menuService;
    private List<Coach> coaches;

    public void startMenuRecommendService() {
        outputView.printServiceStartNotice();
        readCoachNames();
        readDislikeFoods();
    }

    private void readCoachNames() {
        outputView.printCoachNameInputNotice();
        String coachNameInput = inputView.readCoachNames();

        String[] coachNames = coachNameInput.split(",");
        for (String name : coachNames) {
            coaches.add(new Coach(name));
        }
    }

    private void readDislikeFoods() {
        for (Coach coach : coaches) {
            outputView.printDislikeFoodInputNotice(coach.getName());
            coach.addDislikeFood(inputView.readDislikeFoods());
        }
    }

    private void recommendMenu() {
        Category category = categoryService.selectCategory();
        categoryHistory.addCategory(category);

        for (Coach coach : coaches) {
            Menu menu = menuService.selectMenu(coach, category);
            coach.addRecommendedMenu(menu);
        }
    }
}
