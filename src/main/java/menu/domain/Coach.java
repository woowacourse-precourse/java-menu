package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Coach {

    public static final int CATEGORY_MAX_COUNT = 2;

    private final String name;
    private final List<Menu> banFoods;

    private List<Menu> recommendFoods = new ArrayList<>();
    private List<Category> categories = new ArrayList<>();

    public Coach(String name, List<Menu> banFoods) {
        this.name = name;
        this.banFoods = banFoods;
    }

    public boolean canNotEat(Menu menu) {
        return banFoods.contains(menu);
    }
}
