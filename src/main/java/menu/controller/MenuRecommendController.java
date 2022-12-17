package menu.controller;

import menu.model.Category;
import menu.model.DayOfTheWeek;
import menu.service.MenuRecommendService;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.Arrays;
import java.util.List;

public class MenuRecommendController {

    private final OutputView outputView;
    private final InputView inputView;
    private final MenuRecommendService menuRecommendService;

    public MenuRecommendController() {
        this.outputView = new OutputView();
        this.inputView = new InputView();
        this.menuRecommendService = new MenuRecommendService();
    }

    public void start() {
        outputView.printLunchMenuRecommendMessage();
        List<String> coachNames = readCoachNamesStep();
        generateCoachStep(coachNames);
        saveCannotEatFoodsStep(coachNames);
        menuRecommendStep(coachNames);
        printMenuResultStep(coachNames);
    }
    private List<String> readCoachNamesStep() {
        try {
            outputView.printReadCoachNameMessage();
            return inputView.readCoachNames();
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception.getMessage());
            return readCoachNamesStep();
        }
    }

    private void generateCoachStep(List<String> coachNames) {
        menuRecommendService.generateCoachByCoachName(coachNames);
    }

    private void saveCannotEatFoodsStep(List<String> coachNames) {
        for (String coachName : coachNames) {
            List<String> cannotEatFoods = readCannotEatFoodsStep(coachName);
            menuRecommendService.saveCannotEatFoods(coachNames, cannotEatFoods);
        }
    }

    private List<String> readCannotEatFoodsStep(String coachName) {
        try {
            outputView.printCannotEatFoodsByCoachMessage(coachName);
            return inputView.readCannotEatFoods();
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception.getMessage());
            return readCannotEatFoodsStep(coachName);
        }
    }

    private void menuRecommendStep(List<String> coachNames) {
        for (int recommendIndex = 0; recommendIndex < DayOfTheWeek.getDaysOfTheWeekName().size(); recommendIndex++) {
            Category recommendedCategory = menuRecommendService.recommendCategory();
            menuRecommendService.recommendMenu(coachNames, recommendedCategory);
        }
    }


    private void printMenuResultStep(List<String> coachNames) {
        outputView.printMenuRecommendResultMessage();
        outputView.printDayOfTheWeek(DayOfTheWeek.getDaysOfTheWeekName());
        outputView.printCategory(menuRecommendService.getRecommendCategoryNames());
        for (String coachName : coachNames) {
            List<String> recommendedMenus = menuRecommendService.getRecommendMenusByCoachName(coachName);
            outputView.printRecommendMenuByCoach(recommendedMenus);
        }
        outputView.printCompleteRecommendMessage();
    }
}
