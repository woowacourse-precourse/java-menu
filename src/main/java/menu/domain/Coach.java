package menu.domain;

import menu.util.Validator;

public class Coach {
    private final String name;

    public Coach(String name) {
        Validator.validateCoachNameLength(name.length());
        this.name = name;
    }
}
