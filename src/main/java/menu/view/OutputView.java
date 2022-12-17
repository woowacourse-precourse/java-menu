package menu.view;

import java.util.List;
import menu.service.dto.RecommendResultDto;

public class OutputView {

    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String START_MSG = "점심 메뉴 추천을 시작합니다.";
    private static final String START = "[ ";
    private static final String CATEGORY = START + "카테고리 | ";
    private static final String LINE = " | ";
    private static final String END = " ]";
    private static final String DAY_MSG = "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]";
    private static final String END_MSG = "추천을 완료했습니다.";
    private static final String RESULT_START_MSG = "메뉴 추천 결과입니다.";

    private OutputView() {
    }

    public static void printError(final String errorMessage) {
        println(ERROR_PREFIX + errorMessage);
    }

    public static void printStart() {
        println(START_MSG);
    }

    public static void printResult(final RecommendResultDto resultDto) {
        println(RESULT_START_MSG);
        println(DAY_MSG);
        printCategory(resultDto.getCategories());
        resultDto.getCoachMenus().forEach(OutputView::printCoach);
        println();
        println(END_MSG);
    }

    private static void printCategory(final List<String> categories) {
        print(CATEGORY);
        print(String.join(LINE, categories));
        println(END);
    }

    private static void printCoach(final List<String> coachMenu) {
        print(START);
        print(String.join(LINE, coachMenu));
        println(END);
    }

    private static void print(final String message) {
        System.out.print(message);
    }

    private static void println() {
        System.out.println();
    }

    private static void println(final String message) {
        System.out.println(message);
    }
}