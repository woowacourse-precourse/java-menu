package menu.ui;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String SEPARATOR = ",";

    public static String[] coaches() {
        String input = Console.readLine();
        checkSeparator(input);
        return input.split(SEPARATOR);
    }

    private static void checkSeparator(String input) {
        if (!input.contains(",")) {
            throw new IllegalArgumentException(" 구분자(,) 를 입력해주세요.");
        }
    }
}
