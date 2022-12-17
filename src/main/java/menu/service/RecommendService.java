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

public class RecommendService {
    private static final int MAX_RECOMMEND_SIZE = 5;

    private final MenuRepository menuRepository;

    public RecommendService() {
        this.menuRepository = new MenuRepository();
    }

    public List<RecommendResult> findRecommendMenus(final Coaches coaches) {
        RecommendSystem recommendSystem = new RecommendSystem();
        final List<MenuCategory> categories = recommendSystem.pickRandomCategory();
        List<RecommendResult> results = new ArrayList<>();
        int count = 0;
        for (MenuCategory category : categories) {
            count++;
            for (int j = 0; j < coaches.getCoaches().size(); j++) {
                final Coach coach = coaches.getCoaches().get(j);
                final List<String> menus = menuRepository.getMenus(category);
                boolean canNotRecommend = false;
                String menuName = "";
                do {
                    menuName = recommendSystem.pickRandomMenu(menus, coach);
                    canNotRecommend = coach.validateMenu(menuName);
                } while (canNotRecommend);

                if (count == 1) {
                    final Menu menu = new Menu(category, menuName);
                    List<Menu> recommendMenus = new ArrayList<>();
                    recommendMenus.add(menu);
                    RecommendResult result = new RecommendResult(coach, recommendMenus);
                    results.add(result);
                } else {
                    results.get(j).addMenu(new Menu(category, menuName));
                }
            }
        }

        return results;
    }
}