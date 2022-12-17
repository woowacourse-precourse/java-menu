package menu.view;

import menu.model.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author : jeeseob
 * @CreateAt : 2022/12/17
 */
public class OutputView {
    private static final String START_RECOMMEND_MESSAGE = "점심 메뉴 추천을 시작합니다.";
    private static final String INPUT_COACH_NAME = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final String INPUT_HATE_MENU = "(이)가 못 먹는 메뉴를 입력해 주세요.";
    private static final String RESULT_RECOMMEND_MESSAGE = "메뉴 추천 결과입니다.";
    private static final String FINISH_RECOMMEND_MESSAGE = "추천을 완료했습니다.";
    private static final String DIVISION_START = "[";
    private static final String DIVISION_LINE = "|";
    private static final String DIVISION_END = "]";
    private static final String DIVISION_SPACE = " ";
    private static final String DIVISION = "구분";
    private static final String CATEGORY = "카테고리";



    public static void printStartMessage() {
        System.out.println(START_RECOMMEND_MESSAGE);
    }

    public static void printCoachNameMessage() {
        System.out.println(INPUT_COACH_NAME);
    }

    public static void printInputHateMenuMessage(String name) {
        System.out.println(name + INPUT_HATE_MENU);
    }

    public static void printResultMessage() {
        System.out.println(RESULT_RECOMMEND_MESSAGE);
    }

    public static void printFinishMessage() {
        System.out.println(FINISH_RECOMMEND_MESSAGE);
    }

    public static void printResult(List<RecommendResult> recommendResults, List<Coach> coaches) {
        printDivision(recommendResults);
        printCategory(recommendResults);
        printCoachAndMenu(recommendResults, coaches);
    }

    private static void printDivision(List<RecommendResult> recommendResults) {
        List<DayOfTheWeek> dayOfTheWeeks = recommendResults.stream().map(RecommendResult::getDayOfTheWeek).collect(Collectors.toList());
        StringBuilder stringBuilder = new StringBuilder(DIVISION_START + DIVISION_SPACE + DIVISION + DIVISION_SPACE + DIVISION_LINE);
        for (DayOfTheWeek dayOfTheWeek : dayOfTheWeeks) {
            stringBuilder.append(DIVISION_SPACE + dayOfTheWeek.getDayOfTheWeek() + DIVISION_SPACE + DIVISION_LINE);
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        stringBuilder.append(DIVISION_END);
        System.out.println(stringBuilder);
    }

    private static void printCategory(List<RecommendResult> recommendResults) {
        List<MenuCategory> menuCategories = recommendResults.stream().map(RecommendResult::getMenuCategory).collect(Collectors.toList());
        StringBuilder stringBuilder = new StringBuilder(DIVISION_START + DIVISION_SPACE + CATEGORY + DIVISION_SPACE + DIVISION_LINE);
        for (MenuCategory menuCategory : menuCategories) {
            stringBuilder.append(DIVISION_SPACE + menuCategory.getMenuCategory() + DIVISION_SPACE + DIVISION_LINE);
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        stringBuilder.append(DIVISION_END);
        System.out.println(stringBuilder);
    }

    private static void printCoachAndMenu(List<RecommendResult> recommendResults, List<Coach> coaches) {
        List<Map<Coach, Menu>> coachAndMenus = recommendResults.stream().map(RecommendResult::getCoachAndMenu).collect(Collectors.toList());
        for (Coach cocoach : coaches) {
            List<Menu> menus = coachAndMenus.stream().map(coachAndMenu -> coachAndMenu.get(cocoach)).collect(Collectors.toList());
            System.out.println(getMessageByCoach(cocoach, menus));
        }
    }

    private static String getMessageByCoach(Coach coach, List<Menu> menus) {
        StringBuilder stringBuilder = new StringBuilder(DIVISION_START + DIVISION_SPACE + coach.getName() + DIVISION_SPACE + DIVISION_LINE);
        for (Menu menu : menus) {
            stringBuilder.append(DIVISION_SPACE + menu.getName() + DIVISION_SPACE + DIVISION_LINE);
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        stringBuilder.append(DIVISION_END);
        return stringBuilder.toString();
    }
}