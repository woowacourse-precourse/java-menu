package menu.validator;

import menu.constant.Message;

public class InputValidator {

    public static void validateCoachNamesLength(String name){
        if(name.length() < 2 || name.length() > 4){
            throw new IllegalArgumentException(Message.NAME_LENGTH_ERROR);
        }
    }


}
