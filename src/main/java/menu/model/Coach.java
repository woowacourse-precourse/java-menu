package menu.model;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private static final String INVALID_NAME = "코치의 이름이 올바르지 않습니다.";
    public static final String ALREADY_REGISTERED = "해당 코치가 못 먹는 메뉴로 이미 등록돼있습니다.";
    private String name;
    private List<String> menuCannotEat = new ArrayList<>();

    public Coach(String name) {
        validateName(name);
        this.name = name;
    }

    public String getName() {
        return name;

    }

    public void validateName(String name) {
        if (name.length() < 2 || name.length() > 4) {
            throw new IllegalArgumentException(INVALID_NAME);
        }
    }

    public void addMenuCannotEat(String menu) {
        if (isAlreadyRegistered(menu)) {
            throw new IllegalArgumentException(ALREADY_REGISTERED);
        }

    }

    private boolean isAlreadyRegistered(String menu) {
        return menuCannotEat.contains(menu);
    }
}
