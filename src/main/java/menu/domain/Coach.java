package menu.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Coach {

    public static final int NAME_MIN_SIZE = 2;
    public static final int NAME_MAX_SIZE = 4;

    private final String name;
    private final List<Menu> banMenus;

    private List<Menu> recommendMenu = new ArrayList<>();

    public Coach(String name, List<Menu> banMenus) {
        validate(name);
        this.name = name;
        this.banMenus = banMenus;
    }

    public void validate(String name) {
        if (isWrongNameSize(name)) {
            throw new IllegalArgumentException("코치 이름은 최소 2자, 최대 4자 입니다.");
        }
    }

    private boolean isWrongNameSize(String name) {
        return name.length() < NAME_MIN_SIZE || name.length() > NAME_MAX_SIZE;
    }

    public void addMenu(Menu menu) {
        recommendMenu.add(menu);
    }

    public boolean canEat(Menu menu) {
        return !banMenus.contains(menu);
    }

    public boolean hasNotSameMenu(Menu menu) {
        return !recommendMenu.contains(menu);
    }

    public String getName() {
        return name;
    }

    public List<Menu> getRecommendMenu() {
        return Collections.unmodifiableList(recommendMenu);
    }
}
