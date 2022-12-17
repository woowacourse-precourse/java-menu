package menu.view;

import java.util.List;
import menu.service.dto.RecommendResultDto;

public class OutputView {

    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String START_MSG = "점심 메뉴 추천을 시작합니다.";
    private static final String LINE = " | ";
    private static final String START = "[ ";
    private static final String END = " ]";

    private OutputView() {
    }

    public static void printError(final String errorMessage) {
        println(ERROR_PREFIX + errorMessage);
    }

    public static void printStartMessage() {
        println(START_MSG);
    }

    private static void printCoach(final List<String> coachMenu) {
        print(START);
        print(String.join(LINE, coachMenu));
        println(END);
    }

    private static void printCategory(final List<String> categories) {
        print(CATEGORY_MSG);
        print(String.join(LINE, categories));
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