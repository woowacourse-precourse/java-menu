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

    public List<String> requestCannotEatMenu(){
        String[] userInput;
        boolean isRightInput;
        do{
            userInput = Console.readLine().split(",");
            isRightInput = validator.validateNotHaveMenuList(userInput);
        }while(!isRightInput);

        if(userInput[0].length() == 0){
            userInput = null;
        }
        return Arrays.asList(userInput);
    }
}
