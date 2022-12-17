package menu;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Coach {
    private static final int MIN_MEMBER_SIZE = 2;
    private static final int MAX_MEMBER_SIZE = 5;
    private static final int MIN_MEMBER_NAME = 2;
    private static final int MAX_MEMBER_NAME = 4;
    private static final String NUM_OF_NAMES_ERROR = "[ERROR] 코치는 최소 2명 이상 입력해야 합니다.";
    private static final String NAME_LENGTH_ERROR = "[ERROR] 코치의 이름의 길이는 2-4글자 입니다.";


    public List<String> getNames() {
        String line = Console.readLine();
        List<String> names = parseComma(line);
        checkNames(names);
        return names;
    }

    public List<String> getHates() {
        String line = Console.readLine();
        return parseComma(line);
    }

    private List<String> parseComma(String line) {
        List<String> result = new ArrayList<>();
        if (line.equals("")) {
            return result;
        }
        result.addAll(Arrays.asList(line.split(",")));
        return result;
    }

    private void checkNames(List<String> names) {
        if (names.size() < MIN_MEMBER_SIZE || names.size() > MAX_MEMBER_SIZE) {
            throw new IllegalArgumentException(NUM_OF_NAMES_ERROR);
        }

        for (String name : names) {
            if (name.length() < MIN_MEMBER_NAME || name.length() > MAX_MEMBER_NAME) {
                throw new IllegalArgumentException(NAME_LENGTH_ERROR);
            }
        }
    }
}
