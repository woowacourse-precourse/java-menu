package menu.domain;

import menu.domain.enums.Category;

import java.util.ArrayList;
import java.util.List;

public class Coach {

    private static final int MAX_DUPLICATED_COUNT = 2;

    private final String name;
    private final List<Food> inedibleFoods;
    private final List<Recommend> recommends = new ArrayList<>();

    public Coach(String name, List<Food> inedibleFoods) {
        this.name = name;
        this.inedibleFoods = inedibleFoods;
    }

    public static Coach ofName(String name) {
        return new Coach(name, new ArrayList<Food>());
    }

    public String name() {
        return name;
    }

    public List<Recommend> recommends() {
        return recommends;
    }

    public boolean isDuplicatedCategory(Category category) {
        long count = inedibleFoods.stream()
                .filter(it -> it.category().equals(category))
                .count();
        return MAX_DUPLICATED_COUNT <= count;
    }

    public boolean isEdible(Food food) {
        return !inedibleFoods.contains(food);
    }

    public void addInedibleFoods(List<Food> foods) {
        inedibleFoods.addAll(foods);
    }

    public void addRecommend(Recommend recommend) {
        this.recommends.add(recommend);
    }
}
