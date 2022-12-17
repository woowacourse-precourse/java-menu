package menu.view;

import java.util.List;
import menu.service.dto.RecommendResultDto;

public class OutputView {

    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String START_MSG = "점심 메뉴 추천을 시작합니다.";

    private OutputView() {
    }

    public static void printError(final String errorMessage) {
        println(ERROR_PREFIX + errorMessage);
    }

    public static void printStartMessage() {
        println(START_MSG);
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