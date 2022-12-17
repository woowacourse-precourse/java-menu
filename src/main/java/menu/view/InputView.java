package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.utils.Utils;

public class InputView {

    public static String inputCoachNames() {
        System.out.println(System.lineSeparator() + "코치의 이름을 입력해 주세요. (, 로 구분)");
        String coachNames = Console.readLine();
        validateCoachNames(coachNames);
        return coachNames;
    }

    public static String inputCantEat(String coach) {
        System.out.println(System.lineSeparator() + coach + "(이)가 못 먹는 메뉴를 입력해 주세요.");
        String cantEat = Console.readLine();
        validateCantEat(cantEat);
        return cantEat;
    }

    public static void validateCoachNames(String input) {
        Utils.coachPatternMatching(input);
        if (Utils.separator(input).size() < 2) {
            throw new IllegalArgumentException("[ERROR] 코치는 최소 2명 이상이여야 합니다.");
        } else if (Utils.separator(input).size() > 5) {
            throw new IllegalArgumentException("[ERROR] 코치는 최대 5명 이하여야 합니다.");
        }
    }

    public static void validateCantEat(String input) {
        Utils.cantEatPatternMatching(input);
        if (Utils.separator(input).size() > 2) {
            throw new IllegalArgumentException("[ERROR] 못먹는 메뉴는 최대 2개 이하여야 합니다.");
        }
    }
}
