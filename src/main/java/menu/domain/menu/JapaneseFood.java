package menu.domain.menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum JapaneseFood {
    규동("규동"),
    우동("우동"),
    미소시루("미소시루"),
    스시("스시"),
    가츠동("가츠동"),
    오니기리("오니기리"),
    하이라이스("하이라이스"),
    라멘("라멘"),
    오코노미야끼("오코노미야끼"),
    any("any");

    private final String name;

    JapaneseFood(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<String> getAllFoods() {
        List<String> foodNames = new ArrayList<>();
        Arrays.stream(values())
                .map(i -> foodNames.add(i.getName()))
                .collect(Collectors.toList());
        foodNames.remove(any.getName());
        return foodNames;
    }
}
