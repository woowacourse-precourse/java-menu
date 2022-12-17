package menu.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {
    public List<String> scanCoachNames() {
        try {
            System.out.println("코치의 이름을 입력해 주세요(, 로 구분)");
            List<String> names = Arrays.asList(Console.readLine().split(","));
            return validateNames(names);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR]코치의 이름은 ,로 구분하여 2명이상 5명 이하 입니다.");
        }
    }

    private List<String> validateNames(List<String> names) {
        if (names.size() < 2 || 5 < names.size()) {
            throw new IllegalArgumentException("[ERROR] 코치 인원수가 너무 적거나 많음");
        }
        //TODO : 이름 글자수 확인 해야함
        return names;
    }
}
