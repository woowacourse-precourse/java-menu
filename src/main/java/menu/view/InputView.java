package menu.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    public static List<String> readCoachName() {
        return Arrays.stream(Console.readLine().split(","))
                .collect(Collectors.toList());
    }

    public static List<String> readInedibleFoods() {
        return Arrays.stream(Console.readLine().split(","))
                .collect(Collectors.toList());
    }
}
