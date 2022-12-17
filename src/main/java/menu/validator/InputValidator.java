package menu.validator;

import menu.constant.Category;
import menu.constant.Message;

public class InputValidator {
    public static final String KOREAN_REGEX = "^[ㄱ-ㅎ가-힣]*$";
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

    public static void validateExistFood(String banFood){
        if(!Category.isExistFood(banFood)){
            throw new IllegalArgumentException(Message.INVALID_FOOD_ERROR);
        }
    }

    public static void validateNameFormat(String name){
        if(!name.matches(KOREAN_REGEX)){
            throw new IllegalArgumentException(Message.INVALID_NAME_ERROR);
        }
    }


}
