package menu.input;

import camp.nextstep.edu.missionutils.Console;
import menu.type.ValidationType;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    public static List<String> readCoaches() {
        String input = Console.readLine();
        String[] coaches = input.split(",");
        validate(ValidationType.CHECK_COACH_SIZE, String.valueOf(coaches.length));
        for (String coach: coaches) {
            validate(ValidationType.CHECK_NAME_SIZE, String.valueOf(coach.length()));
        }
        return Arrays.stream(coaches).collect(Collectors.toList());
    }

    public static List<String> readMenuNotEat() {
        String input = Console.readLine();
        String[] menus = input.split(",");
        validate(ValidationType.CHECK_MENUS_COUNT, String.valueOf(menus.length));
        for (String menu: menus) {
            validate(ValidationType.CHECK_MENUS, menu);
        }
        return Arrays.stream(menus).collect(Collectors.toList());
    }

    public static void validate(ValidationType validationType, String input) {
        if (!ValidationType.validate(validationType, input)) {
            String errorMessage = validationType.getErrorMessage();
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
