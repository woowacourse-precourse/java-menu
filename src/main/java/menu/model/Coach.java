package menu.model;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private static final String INVALID_NAME = "코치의 이름이 올바르지 않습니다.";
    private String name;
    private List<String> menuCannotEat = new ArrayList<>();

    public Coach(String name) {
        validateName(name);
        this.name = name;
    }

    public void validateName(String name) {
        if (name.length() < 2 || name.length() > 4) {
            throw new IllegalArgumentException(INVALID_NAME);
        }
    }
}
