package menu.domain;


import java.util.ArrayList;
import java.util.List;

public class Coach {
    private static final int MINIMUM_NAME_SIZE = 2;
    private static final int MAXIMUM_NAME_SIZE = 4;
    private final List<String> hateFoods = new ArrayList<>();
    private final String name;

    public Coach(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name.length() < MINIMUM_NAME_SIZE || name.length() > MAXIMUM_NAME_SIZE) {
            throw new IllegalArgumentException("코치 이름은 최소 2글자 이상, 4글자 이하로 입력하세요.");
        }
    }

    public String getName() {
        return this.name;
    }

    public void addHateFoodList(List<String> foodNames) {
        this.hateFoods.addAll(foodNames);
    }

    public boolean isHateFood(String recommendMenu) {
        return hateFoods.contains(recommendMenu);
    }
}
