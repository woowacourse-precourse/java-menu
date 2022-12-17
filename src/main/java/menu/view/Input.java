package menu.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    public List<String> inputCoachNames() {
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
        return validateCoachNumber(inputSplitLineToList());
    }

    public List<String> inputMenus(String name) {
        System.out.println(name + "(이)가 못 먹는 메뉴를 입력해 주세요.");
        return inputSplitLineToList();
    }

    private static List<String> inputSplitLineToList() {
        return Arrays.asList(Console.readLine().split(","));
    }

    private List<String> validateCoachNumber(List<String> names) {
        if (names.size() < 2 || 5 < names.size()) {
            throw new IllegalArgumentException("코치의 인원은 최소 2명, 최대 5명까지 식사를 함께 할 수 있습니다.");
        }
        return names;
    }

}
