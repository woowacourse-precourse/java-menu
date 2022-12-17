package menu.domain;

import java.util.List;

public class Coach {

    private static final int MAXIMUM_NAME_LENGTH = 4;
    private static final int MINIMUM_NAME_LENGTH = 2;
    private static final int MAXIMUM_FOOD_SIZE = 2;
    private final String name;
    private final FoodRepository foodsCanNotEat = new FoodRepository(List.of());

    public Coach(final String name) {
        validate(name);
        this.name = name;
    }

    public void addFoodCanNotEat(final Food food) {
        if (foodsCanNotEat.size() > MAXIMUM_FOOD_SIZE) {
            throw new IllegalArgumentException(
                    "[ERROR] 각 코치가 못 먹는 메뉴은 최대 2개입니다.");
        }

        foodsCanNotEat.add(food);
    }

    public boolean canEat(String menu) {
        return !foodsCanNotEat.contains(menu);
    }

    @Override
    public boolean equals(final Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof Coach) {
            Coach otherCoach = (Coach) other;
            return this.name.equals(otherCoach.name);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    private void validate(final String name) {
        if (name.length() > MAXIMUM_NAME_LENGTH
                || name.length() < MINIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException(
                    "[ERROR] 코치의 이름은 최소 2글자, 최대 4글자입니다.");
        }
    }
}
