package menu.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {

    public List<String> readNames() {
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
        String input = Console.readLine();
        return validateNames(input);
    }

    private List<String> validateNames(String input) {
        String[] names = input.split(",");
        validateCoachSize(names);

        for (String name : names) {
            name = name.trim();
            validateNameSize(name);
        }

        return Arrays.asList(names);
    }

    private void validateCoachSize(String[] names) {
        if (!(2 <= names.length && names.length <= 5)) {
            throw new IllegalArgumentException("코치는 최소 2명에서 5명 사이입니다.");
        }
    }

    private void validateNameSize(String name) {
        int length = name.length();
        if (!(2 <= length && length <= 4)) {
            throw new IllegalArgumentException("코치의 이름은 최소 2글자에서 4글자입니다.");
        }
    }
}
