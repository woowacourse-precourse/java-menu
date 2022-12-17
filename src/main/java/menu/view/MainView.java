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
        System.out.println(INPUT_MESSAGE);

        String result = Console.readLine();
        List<String> resultArray = Arrays.stream(result.split(",")).collect(Collectors.toList());
        System.out.println();
        validate(resultArray);
        return resultArray;
    }

    private static void validate(List<String> names) {
        if (names.size() < 2 || names.size() >= 6) {
            throw new IllegalArgumentException("[ERROR] 코치는 2명 ~ 5명에서 함께 식사할 수 있습니다.");
        }

        names.forEach(name -> {
            if (!(2 <= name.length() && name.length() <= 4)) {
                throw new IllegalArgumentException("[ERROR] 이름은 최소 2글자에서 최대 4글자여야 합니다.");
            }
        });
    }
}
