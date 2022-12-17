package menu.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import menu.utils.Validator;

public class InputView {
    public static List<String> readCoachNames() {
        String names = Console.readLine();
        return parseCoachNames(names);
    }

    private static List<String> parseCoachNames(String names) {
        List<String> parsedNames = List.of(names.split(","));

        Validator.checkCoachSize(parsedNames);
        for (String name : parsedNames) {
            Validator.checkNameLength(name);
        }
        return parsedNames;
    }

    public static ArrayList<String> readBanMenu() {
        String banMenu = Console.readLine();
        return new ArrayList<>(parseBanMenu(banMenu));
    }

    private static List<String> parseBanMenu(String banMenu) {
        List<String> parsedBanMenu = List.of(banMenu.split(","));
        return parsedBanMenu;
    }
}
