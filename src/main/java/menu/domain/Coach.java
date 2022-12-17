package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Coach {

    public static final int NAME_MIN_SIZE = 2;
    public static final int NAME_MAX_SIZE = 4;

    private final String name;
    private final List<Menu> banFoods;

    private List<Menu> recommendMenu = new ArrayList<>();

    public Coach(String name, List<Menu> banFoods) {
        validate(name);
        this.name = name;
        this.banFoods = banFoods;
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
        return !banFoods.contains(menu);
    }

    public boolean hasNotSameMenu(Menu menu) {
        return !recommendMenu.contains(menu);
    }

    public String getName() {
        return name;
    }

    public List<Menu> getRecommendMenu() {
        return recommendMenu;
    }
}
