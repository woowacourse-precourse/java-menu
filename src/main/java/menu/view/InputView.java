package menu.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

public class InputView {
    public static String readNames() {
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
        String names = Console.readLine();
        validateNames(names);
        return names;
    }

    private static void validateNames(String names) {
        String format = "([가-힣0-9a-zA-Z]{2,4},){1,4}([가-힣0-9a-zA-Z]{2,4})";
        if (!Pattern.matches(format, names)) {
            throw new IllegalArgumentException("[ERROR] 이름은 최소 2자에서 4자까지며 코치 명수는 최소 2명에서 최대 5명입니다.");
        }
    }
}
