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

    public List<String> readInedibleOf(String name) {
        System.out.println(name + "(이)가 못 먹는 메뉴를 입력해 주세요.");
        String input = Console.readLine();
        String[] inedibles = input.split(",");
        return List.of(inedibles);
    }
}
