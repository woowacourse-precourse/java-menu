package menu.controller;

import menu.domain.CoachRepository;
import menu.domain.Day;
import menu.domain.MenuRecommendationResult;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.List;
import java.util.function.Supplier;

import static menu.util.TransformInput.splitInput;

public class MenuController {
    private final MenuRecommendationResult menuRecommendationResult = new MenuRecommendationResult();

    public void run() {
        setUp();
        selectCategory();
        recommendDayMenu();

        OutputView.printRecommendationResult(menuRecommendationResult);
        OutputView.printSuccessMessage();
    }

    private void selectCategory() {
        for (Day day : Day.values()) {
            menuRecommendationResult.selectDayCategory(day);
        }
    }

    private void recommendDayMenu() {
        for (Day day : Day.values()) {
            recommendationMenu(day);
        }
    }

    private void recommendationMenu(Day day) {
        for (String coachName : CoachRepository.getCoachNames()) {
            menuRecommendationResult.menuRecommend(day, coachName);
        }
    }

    private void setUp() {
        CoachRepository.nameRegistration(initCoachNames());
        initHateMenu();
    }

    private void initHateMenu() {
        List<String> names = CoachRepository.getCoachNames();
        for (String name : names) {
            String menu = initCoachHateMenu(name);
            CoachRepository.hateMenuRegistration(name, splitInput(menu));
        }
    }

    private String initCoachHateMenu(String name) {
        String menu;
        String coachName = name;
        try {
            menu = InputView.readHateMenu(coachName);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return initCoachHateMenu(coachName);
        }
        return menu;
    }

    private List<String> initCoachNames() {
        String names = repeat(InputView::readCoachName);
        return splitInput(names);
    }

    private <T> T repeat(Supplier<T> inputReader) {
        try {
            return inputReader.get();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return repeat(inputReader);
        }
    }
}
