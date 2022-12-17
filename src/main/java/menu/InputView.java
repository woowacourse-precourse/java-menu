package menu;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class InputView {
    private static final String NAME_COUNT_ERROR_MESSAGE = "[ERROR] 코치 이름을 2명 이상 5명 이하로 입력해주세요.";
    private static final String NAME_SIZE_ERROR_MESSAGE = "[ERROR] 코치 이름은 2글자 이상 4글자 이하입니다.";
    private static final String NAME_DUPLICATE_ERROR_MESSAGE = "[ERROR] 코치 이름이 중복되었습니다.";

    public static List<String> inputNames() {
        while (true) {
            try {
                System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
                String names = Console.readLine();
                List<String> coachNames = Arrays.stream(names.split(","))
                        .map(String::trim)
                        .collect(Collectors.toList());
                checkNamesCount(coachNames);
                checkNameSize(coachNames);
                checkNameDuplicate(coachNames);
                return coachNames;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void checkNamesCount(List<String> names) {
        if (names.size() < 2 || names.size() > 5) {
            throw new IllegalArgumentException(NAME_COUNT_ERROR_MESSAGE);
        }
    }

    private static void checkNameSize(List<String> names) {
        for (String name : names) {
            if (name.length() < 2 || name.length() > 4) {
                throw new IllegalArgumentException(NAME_SIZE_ERROR_MESSAGE);
            }
        }
    }

    private static void checkNameDuplicate(List<String> names) {
        Set<String> notDuplicatedNames = new HashSet<>(names);
        if (names.size() != notDuplicatedNames.size()) {
            throw new IllegalArgumentException(NAME_DUPLICATE_ERROR_MESSAGE);
        }
    }
}
