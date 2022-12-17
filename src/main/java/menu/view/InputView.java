package menu.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {

    private static final String DELIMITER = ",";

    public static List<String> inputCoachNames() {
        OutputView.printInputCoachnames();
        String input = Console.readLine();
        String[] names = input.split(DELIMITER);
        return Arrays.asList(names);
    }

    public static List<String> inputProhibitedFoods(String name) {
        OutputView.printInputProhibitedFoods(name);
        String input = Console.readLine();
        String[] foods = input.split(DELIMITER);
        return Arrays.asList(foods);
    }

}
