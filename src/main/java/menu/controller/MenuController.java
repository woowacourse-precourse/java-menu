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
    private MenuRecommendationResult menuRecommendationResult = new MenuRecommendationResult();
    public void run() {
        setUp();
        selectCategory();

        recommendDayMenu();

        OutputView.printRecommendationResult(menuRecommendationResult);
        OutputView.printSuccessMessage();
    }

    // 요일별 카테고리 선정
    private void selectCategory() {
        for (Day day : Day.values()) {
            menuRecommendationResult.selectDayCategory(day);
        }
    }

    // 코치 한 명씩 메뉴 추천 받음
    private void recommendDayMenu() {
        for (Day day : Day.values()) {
            recommendationMenu(day);
        }
    }

    // 월요일 : 코치 각각 추천받아서 넣어주기 Result객체에 저장
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
