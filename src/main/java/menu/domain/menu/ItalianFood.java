package menu.domain.menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum ItalianFood {
    라자냐("라자냐"),
    그라탱("그라탱"),
    뇨끼("뇨끼"),
    끼슈("끼슈"),
    프렌치_토스트("프렌치 토스트"),
    바게트("바게트"),
    스파게티("스파게티"),
    피자("피자"),
    파니니("파니니"),
    any("any");

    private final String name;

    ItalianFood(String name) {
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
