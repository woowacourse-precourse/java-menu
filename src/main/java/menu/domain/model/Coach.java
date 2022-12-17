package menu.domain.model;

import java.util.List;

public class Coach {

    private static final String ERROR_INVALID_NAME_LENGTH = "[ERROR] 이름은 최소 2글자, 최대 4글지 이어야합니다.";
    private static final int MINIMUM_NAME_LENGTH = 2;
    private static final int MAXIMUM_NAME_LENGTH = 4;
    private static final String ERROR_INVALID_CANNOT_FOOD_SIZE = "[ERROR] 못먹는 메뉴는 최소 0개 최대 2개이어야 합니다.";
    private static final int MAXIMUM_SIZE_CANNOT_FOOD = 2;

    private final String name;
    private final List<Menu> canNotEatFoods;

    public Coach(String name, List<Menu> canNotEatFoods) {
        validateNameLength(name);
        validateCanNotFoodSize(canNotEatFoods);
        this.name = name;
        this.canNotEatFoods = canNotEatFoods;
    }

    private static void validateNameLength(String name) {
        if (name.length() < MINIMUM_NAME_LENGTH || name.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException(ERROR_INVALID_NAME_LENGTH);
        }
    }

    private static void validateCanNotFoodSize(List<Menu> canNotEatFoods) {
        if (canNotEatFoods.size() > MAXIMUM_SIZE_CANNOT_FOOD) {
            throw new IllegalArgumentException(ERROR_INVALID_CANNOT_FOOD_SIZE);
        }
    }

    public boolean canEat(Menu menu) {
        return !canNotEatFoods.contains(menu);
    }
}
