package menu.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import menu.utils.ValidateUtils;
import menu.utils.constants.InputMessage;

public class InputView {
    public static InputView instance = new InputView();

    public static InputView getInstance(){
        return instance;
    }

    public List<String> readCoachNames(){
        try{
            String input = getInput(InputMessage.READ_COACH_NAME.getMessage());
            ValidateUtils.isValidCoachCount(input.split(","));
            return new ArrayList<>(Arrays.asList(input.split(",")));
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return readCoachNames();
        }
    }

    public List<String> readBanFoods(String name){
        try{
            String input = getInput(name+InputMessage.READ_COACH_BAN_FOODS.getMessage());
            ValidateUtils.isValidBanFoodCount(input.split(","));
            return new ArrayList<>(Arrays.asList(input.split(",")));
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return readBanFoods(name);
        }
    }

    private String getInput(String msg){
        System.out.println(msg);
        return Console.readLine();
    }
}
