package menu.model;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private static final long MAX_RECOMMENDED_COUNT = 2L;
    private static final String CANNOT_EAT_SAMY_CATEGORY = "같은 카테고리는 2번만 먹을 수 있습니다.";

    private final String name;
    private final List<String> cannotEatFoods = new ArrayList<>();
    private final List<String> alreadyEatFoods = new ArrayList<>();

    public Coach(final String name) {
        this.name = name;
    }

    public void addCannotEatFood(final List<String> foods) {
        cannotEatFoods.addAll(foods);
    }

    public void addAlreadyEatFood(final List<String> foods) {
        alreadyEatFoods.addAll(foods);
    }

    public boolean cannotEatMenu(final String menu) {
        return cannotEatFoods.contains(menu) || alreadyEatFoods.contains(menu);
    }

    public void validateIfTooManyCategory(final List<String> categoryMenus, final MenuCategory category) {
        final long categoryCount = getCategoryCount(categoryMenus);

        if (categoryCount >= MAX_RECOMMENDED_COUNT) {
            throw new IllegalStateException(CANNOT_EAT_SAMY_CATEGORY);
        }
    }

    private long getCategoryCount(final List<String> categoryMenus) {
        return categoryMenus.stream()
                .map(categoryMenu -> alreadyEatFoods.stream()
                        .filter(food -> food.equals(categoryMenu))
                )
                .count();
    }
}
