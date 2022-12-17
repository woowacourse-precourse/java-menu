package menu;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Coach {
    private static final String NUM_OF_NAMES_ERROR = "[ERROR] 코치는 2-5명까지 함께 식사합니다";
    private static final String NAME_LENGTH_ERROR = "[ERROR] 코치의 이름의 길이는 2-4글자 입니다.";

    public List<String> getNames() {
        String line = Console.readLine();
        List<String> names = parseComma(line);
        checkNames(names);
        return names;
    }

    public List<String> getHates(String name) {
        System.out.println(name + "(이)가 못 먹는 메뉴를 입력해 주세요.");
        String line = Console.readLine();
        List<String> hates = parseComma(line);
        return hates;
    }

    private List<String> parseComma(String line) {
        List<String> result = new ArrayList<>();
        if (line.equals("")) {
            return result;
        }
        for (String item : line.split(",")) {
            result.add(item);
        }
        return result;
    }

    private void checkNames(List<String> names) {
        if (names.size() < 2 || names.size() > 5) {
            throw new IllegalArgumentException(NUM_OF_NAMES_ERROR);
        }

        for (String name : names) {
            if (name.length() < 2 || name.length() > 4) {
                throw new IllegalArgumentException(NAME_LENGTH_ERROR);
            }
        }
    }
}
