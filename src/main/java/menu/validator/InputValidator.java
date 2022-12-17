package menu.validator;

import menu.constant.Message;

public class InputValidator {

    public static void validateCoachNameLength(String name){
        if(name.length() < 2 || name.length() > 4){
            throw new IllegalArgumentException(Message.NAME_LENGTH_ERROR);
        }
    }

    public static void validateCoachNamesNumber(String[] names){
        if(names.length < 2 || names.length > 5){
            throw new IllegalArgumentException(Message.NAMES_NUMBER_ERROR);
        }
    }

    public static void validateBanFoodsNumber(String[] banFoods){
        if(banFoods.length > 2){
            throw new IllegalArgumentException(Message.FOOD_NUMBER_ERROR);
        }
    }


}
