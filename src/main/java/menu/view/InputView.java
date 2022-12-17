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
        InputValidator.validateAllCoachNameLength(coachNames);
        return coachNames;
    }

    public static String[] readBanFoods(){
        String input = Console.readLine();
        String[] banFoods = parse(input);
        InputValidator.validateBanFoodsNumber(banFoods);
        InputValidator.validateDuplicatedBanFoodNames(banFoods);
        InputValidator.validateAllFoodIsExist(banFoods);
        return banFoods;
    }

    private static String[] parse(String input){
        return input.split(SPLIT_REGEX);
    }

}
