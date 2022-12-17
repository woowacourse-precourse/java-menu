package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.validator.InputValidator;

public class InputView {
    public static final String SPLIT_REGEX = "\\s*,\\s*";

    public static String[] readCoachNames(){
        String input = Console.readLine();
        String[] coachNames = parse(input);
        InputValidator.validateCoachNamesNumber(coachNames);
        InputValidator.validateDuplicatedCoachNames(coachNames);
        for(String coachName : coachNames){
            InputValidator.validateNameFormat(coachName);
            InputValidator.validateCoachNameLength(coachName);
        }
        return coachNames;
    }

    public static String[] readBanFoods(){
        String input = Console.readLine();
        String[] banFoods = parse(input);
        InputValidator.validateBanFoodsNumber(banFoods);
        InputValidator.validateDuplicatedBanFoodNames(banFoods);
        for(String banFood : banFoods){
            InputValidator.validateExistFood(banFood);
        }
        return banFoods;
    }

    private static String[] parse(String input){
        return input.split(SPLIT_REGEX);
    }

}
