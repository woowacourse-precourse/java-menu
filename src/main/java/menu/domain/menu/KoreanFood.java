package menu.domain.menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum KoreanFood {
    김밥("김밥"),
    김치찌개("김치찌개"),
    쌈밥("쌈밥"),
    된장찌개("된장찌개"),
    비빔밥("비빔밥"),
    칼국수("칼국수"),
    불고기("불고기"),
    떡볶이("떡볶이"),
    제육볶음("제육볶음"),
    any("any");

    private final String name;

    KoreanFood(String name) {
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
