package menu.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import menu.domain.Coach;
import menu.domain.Food;
import menu.domain.MenuRecommend;

public class MenuRecommendRepository {

    private static final List<MenuRecommend> menuRecommends = new ArrayList<>();

    public static void addRecommend(MenuRecommend menuRecommend) {
        menuRecommends.add(menuRecommend);
    }

    public static List<MenuRecommend> findByCoach(Coach coach) {
        return menuRecommends.stream()
                .filter(menuRecommend -> menuRecommend.hasSameCoach(coach))
                .collect(Collectors.toList());
    }

    public static boolean hasSameMenuOnCoach(Coach coach, Food food) {
        return menuRecommends.stream()
                .filter(menuRecommend -> menuRecommend.hasSameCoach(coach))
                .anyMatch(menuRecommend -> menuRecommend.hasSameMenu(food));
    }
}
