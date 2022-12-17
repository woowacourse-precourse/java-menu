package menu.domain;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Coach {

    private static final String NAME_LENGTH_EXCEPTION_MESSAGE_FORMAT = "[ERROR] 이름의 길이는 %d이상, %d이하 여야 합니다.";

    private static final int MIN_COACH_NAME_LENGTH = 2;
    private static final int MAX_COACH_NAME_LENGTH = 5;
    private static final int MIN_UNEATABLE_FOOD_COUNT = 0;
    private static final int MAX_UNEATABLE_FOOD_COUNT = 2;

    private final String name;
    private Set<String> uneatableFoods;
    private Map<Day, String> eatingFoodLog;

    public Coach(String name) {
        validateName(name);
        this.name = name;
        uneatableFoods = new HashSet<>();
        eatingFoodLog = new HashMap<>();
    }

    private void validateName(String name) {
        if (name.length() < MIN_COACH_NAME_LENGTH || name.length() > MAX_COACH_NAME_LENGTH) {
            throw new IllegalArgumentException(String.format(NAME_LENGTH_EXCEPTION_MESSAGE_FORMAT,
                    MIN_COACH_NAME_LENGTH, MAX_COACH_NAME_LENGTH));
        }
    }

    public void addUneatableFoods(List<String> foods) {
        uneatableFoods.addAll(foods);
    }

    public void addFood(Day day, String food) {
        eatingFoodLog.put(day, food);
    }

    public boolean isEatable(String food) {
        return !uneatableFoods.contains(food);
    }

    public boolean isEatBefore(String food) {
        return eatingFoodLog.values().contains(food);
    }

    public String getName() {
        return name;
    }

    public String getFoodAt(Day day) {
        return eatingFoodLog.get(day);
    }

    public int getMinUneatableFoodCount() {
        return MIN_UNEATABLE_FOOD_COUNT;
    }

    public int getMaxUneatableFoodCount() {
        return MAX_UNEATABLE_FOOD_COUNT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Coach coach = (Coach) o;
        return name.equals(coach.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
