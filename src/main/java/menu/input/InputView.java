package menu.input;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputView {
    public static final String splitString = ",";

    public List<String> readCoaches() {
        String coaches = Console.readLine();
        InputValidation.validateReadCoaches(coaches);
        return new ArrayList<>(Arrays.asList(coaches.split(splitString)));
    }

    public List<String> readNotEatMenus() {
        String menus = Console.readLine();
        InputValidation.validateReadNotEatMenus(menus);
        return new ArrayList<>(Arrays.asList(menus.split(InputView.splitString)));
    }
}
