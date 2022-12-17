package menu.service;

import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Day;
import menu.domain.HateMenu;
import menu.domain.Menu;
import menu.domain.MenuHistory;
import menu.domain.MenuMachine;
import menu.domain.WeekCategory;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class MenuService {

    private static final MenuMachine menuMachine = MenuMachine.getInstance();
    private final Coach coach;
    private final HateMenu hateMenu;
    private final MenuHistory menuHistory;

    public MenuService(Coach coach, HateMenu hateMenu) {
        this.coach = Objects.requireNonNull(coach);
        this.hateMenu = Objects.requireNonNull(hateMenu);
        this.menuHistory = new MenuHistory();
    }

    public List<String> recommendMenusOfWeek(WeekCategory weekCategory) {
        initialize(weekCategory);
        return menuHistory.getMenus().stream()
                .map(Menu::getName)
                .collect(Collectors.toUnmodifiableList());
    }

    private void initialize(WeekCategory weekCategory) {
        for(Day day : Day.values()) {
            Category category = weekCategory.getCategoryOfDay(day);
            Menu menu = recommendMenuFrom(category);
            menuHistory.addMenuOfDay(menu, day);
        }
    }

    private Menu recommendMenuFrom(Category category) {
        Menu menu;
        do {
            menu = menuMachine.recommendMenuFrom(category);
        } while(!isAbleToRecommend(menu));
        return menu;
    }


    private boolean isAbleToRecommend(Menu menu) {
        if(Objects.isNull(menu)) {
            return false;
        }
        return !menuHistory.contains(menu) && !hateMenu.contains(menu);
    }

    public String getCoachName() {
        return coach.getName();
    }
}
