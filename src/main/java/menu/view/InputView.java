package menu.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputView {
    public List<String> readNames() {
        System.out.println("코치의 이름을 입력해주세요. (, 로 구분)");
        String line = Console.readLine();
        return List.of(line.split(","));
    }

    public List<String> readMenuCantEat(String name) {
        System.out.println(name + "(이) 못 먹는 메뉴를 입력해주세요.");
        String line = Console.readLine();
        return List.of(line.split(","));
    }
}
