package menu.view;

import menu.domain.RecommendationMenu;
import menu.domain.RecommendationMenuRepository;

import java.util.List;

public class OutputView {
    private static final String START_MESSAGE = "점심 메뉴 추천을 시작합니다.\n";
    private static final String RESULT_MESSAGE = "메뉴 추천 결과입니다.";
    private static final String COMPLETION_MESSAGE = "\n추천을 완료했습니다.";

    private static final String PREFIX_SQUARE_BRACKET = "[ ";
    private static final String SUFFIX_SQUARE_BRACKET = " ]";
    private static final String DIVIDING_VERTICAL_LINE = " | ";

    private static final String DAY_MESSAGE = "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]";
    private static final String CATEGORY = "카테고리";

    public static void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public static void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public static void printResult(List<String> coachNames, List<String> randomCategories) {
        printResultMessage();
        System.out.println(DAY_MESSAGE);
        printCategory(randomCategories);
        printCoachAndMenu(coachNames);
        printCompletionMessage();
    }

    public static void printCoachAndMenu(List<String> coachNames) {
        for (String coachName : coachNames) {
            RecommendationMenu recommendationMenu = RecommendationMenuRepository.findRecommendationMenuByCoachName(coachName);
            System.out.print(PREFIX_SQUARE_BRACKET + coachName + DIVIDING_VERTICAL_LINE);
            printMenus(recommendationMenu);
            System.out.println(SUFFIX_SQUARE_BRACKET);
        }
    }

    public static void printMenus(RecommendationMenu recommendationMenu) {
        List<String> menu = recommendationMenu.getMenu();
        for (int count = 0; count < menu.size(); count++) {
            System.out.print(menu.get(count));
            if (count != menu.size() - 1) {
                System.out.print(DIVIDING_VERTICAL_LINE);
            }
        }
    }

    public static void printCategory(List<String> randomCategories) {
        System.out.print(PREFIX_SQUARE_BRACKET + CATEGORY + DIVIDING_VERTICAL_LINE);

        for (int count = 0; count < randomCategories.size(); count++) {
            System.out.print(randomCategories.get(count));
            if (count != randomCategories.size() - 1) {
                System.out.print(DIVIDING_VERTICAL_LINE);
            }
        }
        System.out.println(SUFFIX_SQUARE_BRACKET);
    }

    public static void printCompletionMessage() {
        System.out.println(COMPLETION_MESSAGE);
    }
}
