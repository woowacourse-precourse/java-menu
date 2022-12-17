package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.util.Validator;

import java.util.Arrays;
import java.util.List;

public class Input {
    public List<String> readCoachNames() {
        String names = Console.readLine();
        Validator.checkCoachNames(names);
        return Arrays.asList(names.split(","));
    }
}
