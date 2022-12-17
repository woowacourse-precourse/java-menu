package menu.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {
    private static final InputView instance = new InputView();

    public static InputView getInstance() {
        return instance;
    }

    private InputView() {
    }

    public static List<String> readCoachName() {
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
        String name = Console.readLine();
        String[] names = name.split(",");
        return Arrays.asList(names);
    }

    public static List<String> readCantEats(String name) {
        System.out.println(String.format("\n%s(이)가 못 먹는 메뉴를 입력해 주세요.", name));
        String menu = Console.readLine();
        String[] menus = menu.split(",");
        return Arrays.asList(menus);
    }
}
