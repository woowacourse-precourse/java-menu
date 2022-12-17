package menu.domain.menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum ChineseFood {
    깐풍기("깐풍기"),
    볶음면("볶음면"),
    동파육("동파육"),
    짜장면("짜장면"),
    짬뽕("짬뽕"),
    마파두부("마파두부"),
    탕수육("탕수육"),
    토마토_달걀볶음("토마토 달걀볶음"),
    고추잡채("고추잡채"),
    any("any");

    private final String name;

    ChineseFood(String name) {
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
