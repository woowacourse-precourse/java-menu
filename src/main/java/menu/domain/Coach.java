package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private String name;
    private List<String> inedibleFoods;

    public Coach(String name) {
        this.name = name;
        inedibleFoods = new ArrayList<>();
    }

    public void addInedibleFood(String foodName) {
        inedibleFoods.add(foodName);
    }

    public boolean isEdible(String foodName) {
        return inedibleFoods.stream().noneMatch(foodName::equals);
    }

    // TODO: 코치 이름 2글자에서 4글자 검증 기능 구현하기

    public String getName() {
        return name;
    }
}
