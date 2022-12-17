package menu;

import java.util.Arrays;
import java.util.List;

public class InputValidation {

    public void validateNameLength(String name) {
        List<String> names = Arrays.asList(name.split(","));
        for (int i = 0; i < names.size(); i++) {
            if (names.get(i).length() < 2) {
                throw new IllegalArgumentException(ErrorMessage.ERROR.get() + ErrorMessage.NAME_MIN_LENGTH.get());
            }
            if (names.get(i).length() > 4) {
                throw new IllegalArgumentException(ErrorMessage.ERROR.get() + ErrorMessage.NAME_MAX_LENGTH.get());
            }
        }
    }

    public void validateMealSize(String name) {
        List<String> names = Arrays.asList(name.split(","));
        if (names.size() < 2) {
            throw new IllegalArgumentException(ErrorMessage.ERROR.get() + ErrorMessage.MEAL_MIN_SIZE.get());
        }
        if (names.size() > 4) {
            throw new IllegalArgumentException(ErrorMessage.ERROR.get() + ErrorMessage.MEAL_MAX_SIZE.get());
        }
    }

    public boolean handleNameException(String name) {
        try {
            validateMealSize(name);
            validateNameLength(name);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public void validateInedibleNumber(String inedible) {
        List<String> inedibles = Arrays.asList(inedible.split(","));
        if (inedibles.size() > 3) {
            throw new IllegalArgumentException();
        }
    }

    public boolean handleInedibleException(String inedible) {
        try {
            validateInedibleNumber(inedible);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}

enum ErrorMessage {
    ERROR("[ERROR] "),
    NAME_MIN_LENGTH("코치의 이름은 최소 2글자 이상으로 입력해야 합니다."),
    NAME_MAX_LENGTH("코치의 이름은 최대 4글자 이하로 입력해야 합니다."),
    MEAL_MIN_SIZE("코치는 최소 2명 이상 입력해야 합니다."),
    MEAL_MAX_SIZE("코치는 최대 5명 이하로 입력해야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String get() {
        return message;
    }
}