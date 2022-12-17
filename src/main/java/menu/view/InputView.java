package menu.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {

    public static List<String> receiveCoachNames() {
        try {
            String input = receiveInput();
            validateCoaches(input);

            return Arrays.asList(input.split(","));
        } catch (IllegalArgumentException e) {
            return receiveCoachNames();
        }
    }

    public static List<String> receiveUnwantedMenus() {
        try {
            String input = receiveInput();
            validateMenus(input);
            return Arrays.asList(input.split(","));
        } catch (IllegalArgumentException e) {
            return receiveUnwantedMenus();
        }

    }

    private static String receiveInput() {
        String str = Console.readLine();
        return str;
    }

    private static void validateMenus(String input) {
        List<String> menus = Arrays.asList(input.split(","));

        if (menus.size() > 2)
            throw new Error("못먹는 메뉴는 최대 2개까지 입니다.");

        if (input.contains(" "))
            throw new Error("공백은 입력할 수 없슶니다.");
    }

    private static void validateCoaches(String input) {
        List<String> coaches = Arrays.asList(input.split(","));

        if (coaches.size() < 2 || coaches.size() > 5)
            throw new Error("코치는 2명 이상, 5명 이하여야 합니다.");

        for (int i = 0; i < coaches.size(); i++) {
            String name = coaches.get(i);
            if (name.length() < 2 || name.length() > 4)
                throw new Error("코치의 이름은 2~4글자여야 합니다.");
        }

        if (input.contains(" "))
            throw new Error("공백은 입력할 수 없슶니다.");
    }
}
