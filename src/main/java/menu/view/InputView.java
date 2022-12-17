package menu.view;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public List<String> readNames() {
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
        String input = Console.readLine();
        String[] names = input.split(",");
        return List.of(names);
    }
}
