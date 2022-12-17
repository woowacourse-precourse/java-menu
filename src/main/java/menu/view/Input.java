package menu.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    public String[] inputCoachNames() {
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
        return validateCoachNumber(Console.readLine().split(","));
    }

    private String[] validateCoachNumber(String[] names) {
        if (names.length < 2 || 5 < names.length) {
            throw new IllegalArgumentException("코치의 인원은 최소 2명, 최대 5명까지 식사를 함께 할 수 있습니다.");
        }
        return names;
    }

}
