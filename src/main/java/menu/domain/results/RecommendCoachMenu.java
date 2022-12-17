package menu.domain.results;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import menu.domain.coach.Coach;
import menu.domain.menu.Menu;
import menu.domain.menu.MenuCategory;

public class RecommendCoachMenu {
    private final Coach coach;
    private final List<Menu> menus = new ArrayList<>();

    private RecommendCoachMenu(Coach coach) {
        this.coach = coach;
    }

    public static RecommendCoachMenu of(Coach coach) {
        return new RecommendCoachMenu(coach);
    }

    public void addRecommendMenu(Menu menu) {
        if (isUnique(menu) && isEdible(menu)) {
            menus.add(menu);
            return;
        }

        throw new IllegalStateException();
    }

    private boolean isUnique(Menu menu) {
        return !menus.contains(menu);
    }

    private boolean isEdible(Menu menu) {
        return !coach.isAvoidMenu(menu);
    }

    public String resultFormat() {
        List<String> formatComponents = new ArrayList<>();
        formatComponents.add(coach.getName());
        formatComponents.addAll(menus.stream().map(Menu::getName)
                .collect(Collectors.toList()));

        return formatComponents.stream()
                .collect(Collectors.joining(" | ", "[ ", " ]"));
    }
}
