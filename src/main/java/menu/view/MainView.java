package menu.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MainView {
    private static final String NEWLINE = "\n";

    private static final String MAIN_MESSAGE = "점심 메뉴 추천을 시작합니다.";
    private static final String INPUT_MESSAGE = "코치의 이름을 입력해 주세요. (, 로 구분)";


    public static void printMainScreen() {
        System.out.println(MAIN_MESSAGE);
        System.out.printf(NEWLINE);
    }

    public static List<String> getMainValue() {
        try {
            System.out.println(INPUT_MESSAGE);
            String result = Console.readLine();
            List<String> resultArray = Arrays.stream(result.split(",")).collect(Collectors.toList());
            System.out.println();
            validate(resultArray);
            return resultArray;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + NEWLINE);
            return getMainValue();
        }
    }

    private static void validate(List<String> names) {
        validateNamesSize(names);

        names.forEach(name -> {
            if (!(2 <= name.length() && name.length() <= 4)) {
                throw new IllegalArgumentException("[ERROR] 이름은 최소 2글자에서 최대 4글자여야 합니다.");
            }
        });
    }

    private static void validateNamesSize(List<String> names) {
        if (names.size() < 2) {
            throw new IllegalArgumentException("[ERROR] 코치는 최소 2명 이상 입력해야 합니다.");
        }

        if (names.size() >= 6) {
            throw new IllegalArgumentException("[ERROR] 코치는 최대 5명까지 입력할 수 있습니다.");
        }
    }
}
