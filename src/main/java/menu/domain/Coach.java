package menu.domain;

import menu.utils.ErrorMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Coach {

    private static final String MESSAGE_DELIMITER = " | ";
    private static final String MESSAGE_PREFIX = "[ ";
    private static final String MESSAGE_SUFFIX = " ]";

    private final String name;
    private final List<Food> denied = new ArrayList<>();
    private final List<Food> recommend = new ArrayList<>();

    private Coach(String name) {
        String refined = name.trim();
        validateName(refined);
        this.name = refined;
    }

    private void validateName(String name) {
        if (isOutOfRange(name)) {
            throw new IllegalArgumentException(ErrorMessage.COACH_NAME_OUT_OF_RANGE.getMessage());
        }
    }

    private boolean isOutOfRange(String name) {
        return name.length() < 2 || name.length() > 4;
    }

    public static Coach from(String name) {
        return new Coach(name);
    }

    public String getName() {
        return name;
    }

    public void denyFood(List<Food> foods) {
        if (foods == null) {
            return;
        }
        if (!denied.isEmpty()) {
            throw new IllegalStateException(ErrorMessage.COACH_ALREADY_DENY_FOOD.getMessage());
        }
        denied.addAll(foods);
    }

    public boolean isDeny(Food food) {
        return denied.contains(food);
    }

    public void recommend(Food food) {
        recommend.add(food);
        denied.add(food);
    }

    public String toMessage() {
        StringBuilder result = new StringBuilder();
        StringJoiner contents = new StringJoiner(MESSAGE_DELIMITER);
        contents.add(name);
        recommend.stream()
                .map(Food::getAlias)
                .forEach(contents::add);

        return result.append(MESSAGE_PREFIX)
                .append(contents)
                .append(MESSAGE_SUFFIX).toString();
    }
}
