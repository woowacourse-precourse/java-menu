package menu.domain;

import java.util.List;

public class Coach {

    private static final int MINIMUM_NAME_LENGTH = 2;
    private static final int MAXIMUM_NAME_LENGTH = 4;
    private static final int MINIMUM_FOOD_NUMBER = 2;
    private static final String INVALID_NAME_LENGTH = "코치의 이름은 2 ~ 4자 사이여야 합니다.";
    private static final String INVALID_FOOD_NUMBER = "못 먹는 음식은 최대 2개까지만 입력할 수 있습니다.";

    private final String name;
    private final List<String> bannedFoods;

    public Coach(String name, List<String> bannedFoods) {
        validate(name, bannedFoods);
        this.name = name;
        this.bannedFoods = bannedFoods;
    }

    private void validate(String name, List<String> bannedFoods) {
        validateName(name);
        validateFoods(bannedFoods);
    }

    private void validateName(String name) {
        if (name.length() < MINIMUM_NAME_LENGTH || name.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException(INVALID_NAME_LENGTH);
        }
    }

    private void validateFoods(List<String> bannedFoods) {
        if (bannedFoods.size() > MINIMUM_FOOD_NUMBER) {
            throw new IllegalArgumentException(INVALID_FOOD_NUMBER);
        }
    }

    public String getName() {
        return name;
    }

    public List<String> getBannedFoods() {
        return bannedFoods;
    }
}
