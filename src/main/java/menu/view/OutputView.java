package menu.view;

import menu.model.RecommendResult;

import java.util.List;

public class OutputView extends DefaultMessage {

    private static final String START_MESSAGE = "점심 메뉴 추천을 시작합니다.";
    private static final String RESULT_MESSAGE = "메뉴 추천 결과입니다.";
    private static final String END_MESSAGE = "추천을 완료했습니다.";
    private static final String DELIMITER = " | ";
    private static final String OPEN_BRACKET = "[ ";
    private static final String CLOSE_BRACKET = " ]";

    public static void printStartMessage() {
        addNewLine();
        printMessage(START_MESSAGE);
    }

    public static void printResult(final List<RecommendResult> recommendMenus) {
        addNewLine();
        printMessage(RESULT_MESSAGE);
        printDayOfWeek();
        printRecommendCategory(recommendMenus);
        printRecommendResultMessage(recommendMenus);

        addNewLine();
        printMessage(END_MESSAGE);
    }

    private static void printDayOfWeek() {
        printMessage("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
    }

    private static void printRecommendCategory(final List<RecommendResult> recommendMenus) {
        final RecommendResult result = recommendMenus.get(0);
        printMessage(getTypeView(result));
    }

    private static String getTypeView(final RecommendResult result) {
        return OPEN_BRACKET + "카테고리" + DELIMITER + String.join(DELIMITER, result.getMenuCategoryNames()) + CLOSE_BRACKET;
    }

    private static void printRecommendResultMessage(final List<RecommendResult> recommendMenus) {
        recommendMenus.stream()
                .map(OutputView::createResultView)
                .forEach(System.out::println);
    }

    private static String createResultView(final RecommendResult result) {
        return OPEN_BRACKET + result.getCoachName() + DELIMITER +
                String.join(DELIMITER, result.getMenuNames()) + CLOSE_BRACKET;
    }
}
