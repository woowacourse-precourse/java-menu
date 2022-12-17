package menu.service;

import menu.model.Coach;
import menu.model.Coaches;
import menu.model.Menu;
import menu.model.MenuCategory;
import menu.model.RecommendResult;
import menu.model.RecommendSystem;
import menu.repository.MenuRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RecommendService {
    private static final int MAX_RECOMMEND_SIZE = 5;

    private final MenuRepository menuRepository;

    public RecommendService() {
        this.menuRepository = new MenuRepository();
    }

    public List<RecommendResult> findRecommendMenus(final Coaches coaches) {
        RecommendSystem recommendSystem = new RecommendSystem();
        final List<MenuCategory> categories = recommendSystem.pickRandomCategory();

        return coaches.getCoaches().stream()
                .map(coach -> new RecommendResult(coach, findRecommendMenus(categories, coach)))
                .collect(Collectors.toList());
    }

    public List<Menu> findRecommendMenus(final List<MenuCategory> categories, final Coach coach) {
        RecommendSystem recommendSystem = new RecommendSystem();


        final List<Menu> recommendMenus = new ArrayList<>();
        for (MenuCategory category : categories) {
            final List<String> menus = menuRepository.getMenus(category);
            boolean canNotRecommend = false;
            String menuName = "";
            do {
                menuName = recommendSystem.pickRandomMenu(menus, coach);
                canNotRecommend = coach.validateMenu(menuName);
            } while (canNotRecommend);

            recommendMenus.add(new Menu(category, menuName));
        }

        return recommendMenus;
    }
}