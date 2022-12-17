package menu.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {
    public static List<String> readCoachNameList() {
        return Arrays.asList(Console.readLine().split(","));
    }

    public static List<String> readMenuCoachCannotEat() {
        return Arrays.asList(Console.readLine().split(","));
    }
}
