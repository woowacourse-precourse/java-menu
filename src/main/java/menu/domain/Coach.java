package menu.domain;

import menu.utils.ExceptionMessage;

import java.util.*;

public class Coach {

    private static final int MiN_NAME_LENGTH = 2;
    private static final int MAX_NAME_LENGTH = 4;

    private final String name;
    private final List<String> menus = new ArrayList<>();
    private final List<String> cantEat = new ArrayList<>();

    public Coach(String name) {
        validate(name);
        this.name = name;
        this.menus.add(name);
    }

    private void validate(String name) {
        if (name.length() < MiN_NAME_LENGTH || MAX_NAME_LENGTH < name.length()) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_SATISFIED_NAME_LENGTH.get());
        }
    }

    public void addMenu(String menu) {
        menus.add(menu);
    }

    public void addCantEat(String menu) {
        cantEat.add(menu);
        cantEat.remove("");
    }

    public boolean hasSameMenuRecommend(String menu) {
        return menus.contains(menu);
    }

    public boolean isCantEatMenu(String menu) {
        return cantEat.contains(menu);
    }

    public String getName() {
        return name;
    }

    public List<String> menus() {
        return Collections.unmodifiableList(menus);
    }
}
