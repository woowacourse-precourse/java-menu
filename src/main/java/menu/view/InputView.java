package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.view.validator.Validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputView {

    private final Validator validator = new Validator();

    public List<String> readCoachNames() {
        String input = Console.readLine();
        validator.validateDelimiter(input);
        List<String> names = Arrays.asList(input.split(Validator.DELIMITER));
        validator.validateCoachNames(names);
        return names;
    }

    public List<String> readHateMenus() {
        String input = Console.readLine();
        List<String> menus = new ArrayList<>();
        if (input.contains(Validator.DELIMITER)) {
            menus.addAll(Arrays.asList(input.split(Validator.DELIMITER)));
            validator.validateHateMenus(menus);
            return menus;
        }
        menus.add(input);
        return menus;
    }
}
