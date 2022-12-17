package menu.domain.menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum AsianFood {
    팟타이("팟타이"),
    카오_팟("카오 팟"),
    나시고렝("나시고렝"),
    파인애플_볶음밥("파인애플 볶음밥"),
    쌀국수("쌀국수"),
    똠얌꿍("똠얌꿍"),
    반미("반미"),
    월남쌈("월남쌈"),
    분짜("분짜"),
    any("any");

    private final String name;

    AsianFood(String name) {
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
