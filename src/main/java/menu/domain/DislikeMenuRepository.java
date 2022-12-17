package menu.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DislikeMenuRepository {
    private final Map<Coach, List<Menu>> menus = new HashMap<>();

    public void add(String userInput, Coach coach) {
        if (userInput.trim().length() > 0) {
            List<Menu> disLikeMenus = new ArrayList<>();
            List<String> InputDislikeFoods = List.of(userInput.split(","));
            if (InputDislikeFoods.size() > 2) throw new IllegalArgumentException("[ERROR] 못먹는 음식은 두개까지만 입력해주세요.");
            for (String InputDislikeFood : InputDislikeFoods) {
                disLikeMenus.add(new Menu(InputDislikeFood.trim()));
            }
            menus.put(coach, disLikeMenus);
        }
    }
}
