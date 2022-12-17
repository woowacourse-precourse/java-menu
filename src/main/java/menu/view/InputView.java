package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.util.Validator;

import java.util.Arrays;
import java.util.List;

public class InputView {

    private String getUserInput(){
        return Console.readLine();
    }

    public List<String> getCoachNames(){
        String userInput = getUserInput();
        List<String> names = Arrays.asList(userInput.split(","));
        Validator.validateCoachNamesSize(names);
        return names;
    }

    public List<String> getHateMenus(){
        String userInput = getUserInput();
        List<String> hateMenus = Arrays.asList(userInput.split(","));
        Validator.validateHateMenusSize(hateMenus);
        return hateMenus;
    }

}
