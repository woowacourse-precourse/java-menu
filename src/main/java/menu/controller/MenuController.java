package menu.controller;

import menu.domain.CoachRepository;
import menu.domain.Day;
import menu.domain.MenuRecommendationResult;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.HashMap;
import java.util.List;
import java.util.function.Supplier;

import static menu.util.TransformInput.splitInput;

public class MenuController {
    private MenuRecommendationResult menuRecommendationResult = new MenuRecommendationResult();
    public void run() {
        setUp();
        selectCategory();

        recommendCoachMenu();

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
    private void recommendCoachMenu() {
        for (String coachName : CoachRepository.getCoachNames()) {
            recommendationMenu(coachName);
        }
    }

    // 1명 코치 기준 : 월화수목금 추천받은거 result에 저장해서 Result객체에 저장
    private void recommendationMenu(String coachName) {
        HashMap<Day, String> result = new HashMap<>();
        for (Day day : Day.values()) {
            result.put(day, menuRecommendationResult.menuRecommend(day, coachName));
        }
        menuRecommendationResult.setRecommendationResult(coachName, result);
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
