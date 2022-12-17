package menu.view;

import menu.domain.Menu;

import java.util.ArrayList;
import java.util.List;

import static menu.constant.MessageConstant.*;

public class OutputView {
    /**
     * 게임 시작 문구를 출력 한다.
     */
    public void printStart() {
        System.out.println(MESSAGE_OUTPUT_START);
    }

    public void printEnd() {
        System.out.println(MESSAGE_OUTPUT_END);
    }


    public void printError(String errorMessage) {
        System.out.println(errorMessage);
    }

    public void printResult(List<String> categoryResult, List<List<String>> menuResult) {
        System.out.println(MESSAGE_OUTPUT_RESULT);

        System.out.printf(MESSAGE_OUTPUT_BRACKET, String.join(MESSAGE_OUTPUT_WALL, categoryResult));
        printBlank();
        for (List<String> eachMenuResult : menuResult) {
            System.out.printf(MESSAGE_OUTPUT_BRACKET, String.join(MESSAGE_OUTPUT_WALL, eachMenuResult));
            printBlank();
        }
        printBlank();
    }

    public void printBlank() {
        System.out.println();
    }

}
