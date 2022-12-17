package menu.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputView {
    public static List<String> readCoachNames() {
        String names = Console.readLine();
        return parseCoachNames(names);
    }

    private static List<String> parseCoachNames(String names) {
        return List.of(names.split(","));
    }
}
