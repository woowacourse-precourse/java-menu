package menu.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class Input {

    public List<String> inputCoachNames() {
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
        return validateListSize(inputSplitLineToList(), 2, 5);
    }

    public List<String> inputMenus(String name) {
        System.out.println(name + "(이)가 못 먹는 메뉴를 입력해 주세요.");
        return validateListSize(inputSplitLineToList(), 0, 2);
    }

    private static List<String> inputSplitLineToList() {
        return Arrays.asList(Console.readLine().split(","));
    }

    private List<String> validateListSize(List<String> names, int from, int to) {
        if (names.size() < from || to < names.size()) {
            throw new IllegalArgumentException("코치의 인원은 최소 2명, 최대 5명까지 식사를 함께 할 수 있습니다.");
        }
        return names;
    }

}
