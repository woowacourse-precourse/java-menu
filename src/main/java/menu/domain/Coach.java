package menu.domain;

import menu.domain.enums.Category;

import java.util.ArrayList;
import java.util.List;

public class Coach {

    private static final int MAX_DUPLICATED_COUNT = 2;

    private final String name;
    private final List<Food> inedibleFoods;
    private final List<Food> recommends = new ArrayList<>();

    public Coach(final String name, final List<Food> inedibleFoods) {
        this.name = name;
        this.inedibleFoods = inedibleFoods;
    }

    public static Coach ofName(final String name) {
        return new Coach(name, new ArrayList<>());
    }

    public String name() {
        return name;
    }

    public List<Food> recommends() {
        return recommends;
    }

    public boolean isDuplicatedCategory(final Category category) {
        long count = inedibleFoods.stream()
                .filter(it -> it.category().equals(category))
                .count();
        return MAX_DUPLICATED_COUNT <= count;
    }

    public boolean isEdible(final Food food) {
        return !inedibleFoods.contains(food);
    }

    public void addInedibleFoods(final List<Food> foods) {
        inedibleFoods.addAll(foods);
    }

    public void addRecommend(final Food food) {
        this.recommends.add(food);
    }
}
