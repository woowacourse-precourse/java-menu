package menu.domain;

import java.util.List;

public class Coach {
    private final String name;
    private final List<String> menus;

    public Coach(String name, List<String> menus) {
        validateName(name);
        this.name = name;
        this.menus = menus;
    }

    private void validateName(String name) {
        if (name.length() < 2 || name.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 코치의 이름은 2글자에서 4글자만 가능합니다.");
        }
    }
}
