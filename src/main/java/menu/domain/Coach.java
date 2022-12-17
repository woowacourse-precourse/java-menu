package menu.domain;

import java.util.List;

public class Coach {

    private static final int VALID_NAME_LOWER_BOUND = 2;
    private static final int VALID_NAME_UPPER_BOUND = 4;
    private static final String INVALID_NAME_MESSAGE = "코치님의 이름은 2 ~ 4글자여야 합니다.";

    private final String name;
    private final Menus invalidMenus = new Menus();
    private final Menus recommendMenus = new Menus();

    public Coach(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name.length() < VALID_NAME_LOWER_BOUND || VALID_NAME_UPPER_BOUND < name.length()) {
            throw new IllegalArgumentException(INVALID_NAME_MESSAGE);
        }
    }

    public void addInvalidMenus(List<Menu> menus) {
        invalidMenus.addAll(menus);
    }

    public void addRecommendMenu(Menu menu) {
        recommendMenus.add(menu);
    }

    public List<String> getRecommendMenuNames() {
        return recommendMenus.getNames();
    }

    public boolean isInvalidMenu(Menu menu) {
        return invalidMenus.isInvalidMenu(menu) || recommendMenus.isInvalidMenu(menu);
    }

    public String getName() {
        return name;
    }
}
