package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.util.Validator;

import java.util.Arrays;
import java.util.List;

import static menu.util.Constants.COACH_NAMES_INPUT_SEPARATOR;
import static menu.util.Constants.HATE_MENUS_INPUT_SEPARATOR;

public class InputView {

    private String getUserInput(){
        return Console.readLine();
    }

    public List<String> getCoachNames(){
        String userInput = getUserInput();
        List<String> names = Arrays.asList(userInput.split(COACH_NAMES_INPUT_SEPARATOR));
        Validator.validateCoachNamesSize(names);
        return names;
    }

    public List<String> getHateMenuNames(){
        String userInput = getUserInput();
        List<String> hateMenus = Arrays.asList(userInput.split(HATE_MENUS_INPUT_SEPARATOR));
        Validator.validateHateMenusSize(hateMenus);
        return hateMenus;
    }

}
