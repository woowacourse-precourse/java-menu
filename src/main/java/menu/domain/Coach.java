package menu.domain;

import menu.exception.InputException;

public class Coach {
    private final String name;

    public Coach(String name) {
        validateNickname(name);
        this.name = name;
    }

    private void validateNickname(String name) {
        if(name.length()<2 || 4<name.length())
            throw new IllegalArgumentException(InputException.INVALID_NAME_LENGTH.getMessage());
    }
}
