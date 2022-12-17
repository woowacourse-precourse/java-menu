package menu.View;

import menu.Model.Coach;
import menu.Model.Coachs;
import menu.Model.Category;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final String READ_COACH_NAMES = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private final String READ_INEDIBLES = "%s(이)가 못 먹는 메뉴를 입력해 주세요.";

    private final String INVALID_FOOD = "음식이 메뉴에 없습니다.";

    public Coachs readCoachNames() {
        System.out.println(READ_COACH_NAMES);
        String input = Console.readLine();
        System.out.println();
        return new Coachs(input);
    }

    public List<String> readInedibles(Coach coach) {
        System.out.println(String.format(READ_INEDIBLES, coach.getName()));
        String input = Console.readLine();
        if (input.length() == 0)
            return List.of();
        List<String> inedibles = List.of(input.split(","));
        System.out.println(inedibles.size());
        for (String food : inedibles) {
            if (!Category.checkFoodInMenus(food)) {
                throw new IllegalArgumentException(INVALID_FOOD);
            }
        }
        System.out.println();
        return inedibles;
    }
}
