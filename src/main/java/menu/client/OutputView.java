package menu.client;

import java.util.List;
import menu.di.RecommendResultDto;

class OutputView {

    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String START_MESSAGE = "점심 메뉴 추천을 시작합니다.";
    private static final String START = "[ ";
    private static final String CATEGORY_START = START + "카테고리 | ";
    private static final String DELIMITER = " | ";
    private static final String END = " ]";
    private static final String DAY_MESSAGE = "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]";
    private static final String FINISH_MESSAGE = "추천을 완료했습니다.";
    private static final String RESULT_START_MESSAGE = "메뉴 추천 결과입니다.";

    private OutputView() {
    }

    static void printErrorMessage(String errorMessage) {
        println(ERROR_PREFIX + errorMessage);
    }

    static void printStartMessage() {
        println(START_MESSAGE);
    }

    static void printResult(RecommendResultDto resultDto) {
        println(RESULT_START_MESSAGE);
        println(DAY_MESSAGE);
        printCategory(resultDto.getCategories());
        resultDto.getCoachMenus().forEach(OutputView::printCoach);
        println();
        println(FINISH_MESSAGE);
    }

    private static void printCategory(List<String> categories) {
        print(CATEGORY_START);
        print(String.join(DELIMITER, categories));
        println(END);
    }

    private static void printCoach(List<String> coachMenu) {
        print(START);
        print(String.join(DELIMITER, coachMenu));
        println(END);
    }

    private static void print(String message) {
        System.out.print(message);
    }

    private static void println() {
        System.out.println();
    }

    private static void println(String message) {
        System.out.println(message);
    }
}
