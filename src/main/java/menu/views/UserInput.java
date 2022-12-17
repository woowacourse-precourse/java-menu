package menu.views;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class UserInput {
    private final Validator validator = new Validator();

    public List<String> requestCoachName(){
        String[] userInput;
        boolean isRightInput;
        do{
            userInput = Console.readLine().split(",");
            isRightInput = validator.validateCoachList(userInput);
        }while(!isRightInput);

        return Arrays.asList(userInput);
    }
}
