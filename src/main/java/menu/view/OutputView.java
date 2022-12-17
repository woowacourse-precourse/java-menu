package menu.view;

import menu.domain.Categories;
import menu.domain.CoachRepository;
import menu.domain.Day;
import menu.domain.MenuRecommendationResult;

import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

public class OutputView {
    private static final String START_MESSAGE = "점심 메뉴 추천을 시작합니다.";
    private static final String COACH_NAME = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final String HATE_MENU = "%s(이)가 못 먹는 메뉴를 입력해 주세요.";
    private static final String RESULT = "메뉴 추천 결과입니다.";
    private static final String SUCCESS = "추천을 완료했습니다.";

    public static void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public static void printInputCoachName() {
        System.out.println(COACH_NAME);
    }

    public static void printInputHateMenu(String name) {
        System.out.println(String.format(HATE_MENU, name));
    }

    public static void printRecommendationResult(MenuRecommendationResult menuRecommendationResult) {
        System.out.println(RESULT);
        printDays();
        printCategories();
        printResult(menuRecommendationResult);
    }

    public static void printSuccessMessage() {
        System.out.println(SUCCESS);
    }

    private static void printDays() {
        StringJoiner sj = new StringJoiner(" | ", "[ ", " ]");
        sj.add("구분");
        for (Day day : Day.values()) {
            sj.add(day.getName());
        }
        System.out.println(sj.toString());
    }

    private static void printCategories() {
        StringJoiner sj = new StringJoiner(" | ", "[ ", " ]");
        sj.add("카테고리");
        for (Categories category : Categories.values()) {
            sj.add(category.getName());
        }
        System.out.println(sj.toString());
    }

    private static void printResult(MenuRecommendationResult menuRecommendationResult) {
        List<String> coachNames = CoachRepository.getCoachNames();
        StringJoiner sj = new StringJoiner(" | ", "[ ", " ]");
        Map<Day, Map<String, String>> result = menuRecommendationResult.getRecommendationResult();
        for (int i = 0; i < coachNames.size(); i++) {
            sj.add(coachNames.get(i));
            for (Day day : Day.values()) {
                sj.add(result.get(day).get(coachNames.get(i)));
            }
            System.out.println(sj.toString());
            sj = new StringJoiner(" | ", "[ ", " ]");
        }
    }

    public static void printErrorMessage(String error) {
        System.out.println(error);
    }
}
