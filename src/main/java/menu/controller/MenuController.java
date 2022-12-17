package menu.controller;

import menu.domain.coach.Coach;
import menu.service.CoachService;
import menu.service.MenuService;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.List;
import java.util.function.Consumer;

public class MenuController {
    private final MenuService menuService = new MenuService();
    private final CoachService coachService = new CoachService();
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();

    private void addDoNotRecommendMenus(Coach coach) {
        List<String> doNoRecommendFoods = inputView.readDoNotRecommendFoodsOf(coach.getName());
        menuService.validateMenusExist(doNoRecommendFoods);
        coachService.addDoNotRecommendFoods(coach, doNoRecommendFoods);
    }

    private void addCoaches() {
        outputView.printStartMessage();
        List<String> coachNames = inputView.getCoachNames();
        coachService.addCoaches(coachNames);
    }

    private void addDoNotRecommendMenus() {
        for (Coach coach : coachService.getAllCoaches()) {
            repeat(this::addDoNotRecommendMenus, coach);
        }
    }

    private void selectRecommendMenus() {
        menuService.selectCategories();
        coachService.recommendMenus();
    }

    private void showRecommendMenus() {
        outputView.printStartRecommend();
        outputView.printCategories(menuService.getRecommendedCategories());
        for (Coach coach : coachService.getAllCoaches()) {
            outputView.printRecommendedMenus(coach.getName(), coach.getRecommendedFoods());
        }
    }

    public void run() {
        repeat(this::addCoaches);
        addDoNotRecommendMenus();
        selectRecommendMenus();
        showRecommendMenus();
        outputView.printEndMessage();
    }

    private <T> void repeat(Consumer<T> function, T argument) {
        try {
            function.accept(argument);
        } catch (IllegalArgumentException exception) {
            outputView.printError(exception.getMessage());
            repeat(function, argument);
        }
    }

    private void repeat(Runnable function) {
        try {
            function.run();
        } catch (IllegalArgumentException exception) {
            outputView.printError(exception.getMessage());
            repeat(function);
        }
    }

}
