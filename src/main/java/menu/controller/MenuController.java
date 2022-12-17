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
    public void run() {
        setUp();
        MenuRecommendationResult menuRecommendationResult = new MenuRecommendationResult();
        selectCategory(menuRecommendationResult);

        recommendCoachMenu(menuRecommendationResult);

        System.out.println(menuRecommendationResult.toString());
        System.out.println(CoachRepository.getCoachHateMenu().toString());

        OutputView.printRecommendationResult(menuRecommendationResult);
        OutputView.printSuccessMessage();
    }

    // 요일별 카테고리 선정
    private void selectCategory(MenuRecommendationResult menuRecommendationResult) {
        for (Day day : Day.values()) {
            menuRecommendationResult.selectDayCategory(day);
        }
    }

    private void recommendCoachMenu(MenuRecommendationResult menuRecommendationResult) {
        for (String coachName : CoachRepository.getCoachNames()) {
            recommendationMenu(menuRecommendationResult, coachName);
        }
    }

    private void recommendationMenu(MenuRecommendationResult menuRecommendationResult, String coachName) {
        for (Day day : Day.values()) {
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
            String menu = InputView.readHateMenu(name);
            CoachRepository.hateMenuRegistration(name, splitInput(menu));
        }
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
