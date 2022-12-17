package menu.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import menu.Coaches;

public class InputView {

    public void inputCoaches() {
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");

        Coaches.listToCoaches(checkComma(Console.readLine()));
    }

    public List<String> checkComma(String input) {
        return List.of(input.split(","));
    }
}
