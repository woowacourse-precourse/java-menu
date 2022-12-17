package menu.view;

import java.util.List;
import menu.domain.Coach;

public class OutputView {

    private static final String RESULT_PHRASE = "메뉴 추천 결과입니다.\n"
        + "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]";
    private static final String CATEGORY_PHRASE = "[ 카테고리 ";
    private static final String SEPARATOR = "| ";
    private static final String SPACE = " ";
    private static final String START_BRACKET = "[ ";
    private static final String END_BRACKET = "]";
    private static final String START_PHRASE = "점심 메뉴 추천을 시작합니다.+\n";

    public static void printPhrase(String phrase) {
        System.out.println(phrase);
    }

    // 시작 문구 출력 기능
    public static void printStart() {
        System.out.println(START_PHRASE);
    }

    public static void printResult(List<Coach> coaches, List<String> categories) {
        System.out.println(RESULT_PHRASE);
        printRecommendCategory(categories);
        printRecommandMenu(coaches);
    }

    // 추천 카테고리를 출력하는 기능
    private static void printRecommendCategory(List<String> categories) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(CATEGORY_PHRASE);
        for (String category : categories) {
            stringBuilder.append(SEPARATOR + category + SPACE);
        }
        stringBuilder.append(END_BRACKET);
        String categoryResult = stringBuilder.toString();
        System.out.println(categoryResult);
    }

    // 코치별 추천 매뉴를 출력하는 기능
    private static void printRecommandMenu(List<Coach> coaches) {
        for (Coach coach : coaches) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(START_BRACKET + coach.getName() + SPACE);
            for (String menu : coach.getRecommendedMenu()) {
                stringBuilder.append(SEPARATOR + menu + SPACE);
            }
            stringBuilder.append(END_BRACKET);
            String menuResult = stringBuilder.toString();
            System.out.println(menuResult);
        }
    }
}
