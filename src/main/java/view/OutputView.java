package view;

import static constant.ViewMessage.*;

public class OutputView {
    private void println(String value) {
        System.out.println(value);
    }

    private void printNewLine() {
        System.out.println();
    }

    private String integerToString(int numericValue) {
        return Integer.toString(numericValue);
    }

    private void print(String value) {
        System.out.print(value);
    }

    private void printFormat(String value, String formatValue) {
        System.out.printf(value, formatValue);
    }

    public void printExceptionMessage(Exception exception) {
        println("[ERROR] " + exception.getMessage());
    }

    public void printInfo(String value) {
        println("[INFO] " + value);
    }

    public void printStartMessage() {
        println(START_MESSAGE);
        printNewLine();
    }

    public void printReadingCoachNames() {
        println(READ_COACH_NAMES);
    }
}
