package menu.domain;

import menu.utils.ExceptionMessage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Coach {

    private static final int MiN_NAME_LENGTH = 2;
    private static final int MAX_NAME_LENGTH = 4;
    private static final int MAX_PICKY_FOOD_NUMBER = 2;

    private final String name;
    private final List<String> menus = new ArrayList<>();
    private final List<String> cantEat = new ArrayList<>();

    public Coach(String name) {
        validateName(name);
        this.name = name;
        this.menus.add(name); // 인덱스 0번은 리스트의 주체
    }

    private void validateName(String name) {
        if (name.length() < MiN_NAME_LENGTH || MAX_NAME_LENGTH < name.length()) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_SATISFIED_NAME_LENGTH.get());
        }
    }

    public void addMenu(String menu) {
        menus.add(menu);
    }

    public void addCantEat(String menu) {
        validateCantEatMenu();
        cantEat.add(menu);
    }

    private void validateCantEatMenu() {
        if (cantEat.size() >= MAX_PICKY_FOOD_NUMBER) {
            cantEat.clear();
            throw new IllegalArgumentException(ExceptionMessage.OVER_MAX_PICKY_FOOD.get());
        }
    }

    public boolean hasSameMenuRecommend(String menu) {
        return menus.contains(menu);
    }

    public boolean canEatMenu(String menu) {
        return !cantEat.contains(menu);
    }

    public String getName() {
        return name;
    }

    public List<String> menus() {
        return Collections.unmodifiableList(menus);
    }
}
