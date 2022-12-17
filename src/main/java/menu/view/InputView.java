package menu.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    public List<String> readNames() {
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
        String input = Console.readLine();
        String[] names = input.split(",");
        return Arrays.asList(names);
    }

    public List<String> readCantEatMenu() {
        String input = Console.readLine();
        String[] cantEatMenus = input.split(",");
        validateCantEatMenusSize(cantEatMenus);
        return Arrays.stream(cantEatMenus)
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private void validateCantEatMenusSize(String[] cantEatMenus) {
        if (2 < cantEatMenus.length) {
            throw new IllegalArgumentException("못 먹는 메뉴는 최대 2개까지 입력해 주세요.");
        }
    }
}
