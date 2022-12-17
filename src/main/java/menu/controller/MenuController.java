package menu.controller;

import menu.domain.coach.Coach;
import menu.service.CoachService;
import menu.service.MenuService;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

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

    public void run() {
        outputView.printStartMessage();
        List<String> coachNames = repeat(inputView::getCoachNames);
        coachService.addCoaches(coachNames);
        for (Coach coach : coachService.getAllCoaches()) {
            repeat(this::addDoNotRecommendMenus, coach);
        }
        menuService.selectCategories();
        coachService.recommendMenus();
    }

    private <T> T repeat(Supplier<T> function) {
        try {
            return function.get();
        } catch (IllegalArgumentException exception) {
            outputView.printError(exception.getMessage());
            return repeat(function);
        }
    }

//    private <T, R> R repeat(Function<T, R> function, T argument) {
//        try {
//            return function.apply(argument);
//        } catch (IllegalArgumentException exception) {
//            outputView.printError(exception.getMessage());
//            return repeat(function, argument);
//        }
//    }

    private <T> void repeat(Consumer<T> function, T argument) {
        try {
            function.accept(argument);
        } catch (IllegalArgumentException exception) {
            outputView.printError(exception.getMessage());
            repeat(function, argument);
        }
    }
}
