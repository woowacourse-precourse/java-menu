package menu.domain;

import static menu.utils.ErrorMessage.*;

public class Coach {
    private final String name;

    public Coach(String name) {
        validateNameRange(name);
        this.name = name;
    }

    private void validateNameRange(String name) {
        if (name.length() < 2 || name.length() > 4) {
            throw new IllegalArgumentException(COACH_NAME_NOT_RANGE);
        }
    }

    public String getName() {
        return name;
    }
}
