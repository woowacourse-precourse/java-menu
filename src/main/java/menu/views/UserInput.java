package menu.views;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

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
            try{
                userInput = Console.readLine().split(",");
            }catch(NoSuchElementException ex){return null;}

            isRightInput = validator.validateNotHaveMenuList(userInput);
        }while(!isRightInput);
        return Arrays.asList(userInput);
    }
}
