package menu.domain;


import java.util.ArrayList;
import java.util.List;

public class Coach {
    private final String name;
    private List<String> hateFoods = new ArrayList<>();

    public Coach(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name.length() < 2 || name.length() > 4) {
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
