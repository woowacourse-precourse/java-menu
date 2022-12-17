package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.util.Validator;

import java.util.Arrays;
import java.util.List;

public class InputView {

    public List<String> getCoachNames(){
        String userInput = getUserInput();
        List<String> names = Arrays.asList(userInput.split(","));
        Validator.validateCoachNamesSize(names);
        return names;
    }

    private String getUserInput(){
        return Console.readLine();
    }
}
