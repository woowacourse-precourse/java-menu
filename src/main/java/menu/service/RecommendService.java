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
        return coaches.getCoaches().stream()
                .map(coach -> new RecommendResult(coach, findRecommendMenus(coach)))
                .collect(Collectors.toList());
    }

    public List<Menu> findRecommendMenus(final Coach coach) {
        RecommendSystem recommendSystem = new RecommendSystem();

        return findRecommendMenus(coach, recommendSystem);
    }

    private List<Menu> findRecommendMenus(final Coach coach, final RecommendSystem recommendSystem) {
        List<Menu> recommendMenus = new ArrayList<>();
        while (recommendMenus.size() < MAX_RECOMMEND_SIZE) {
            final Menu recommendMenu = doRecommend(coach, recommendSystem);
            recommendMenus.add(recommendMenu);
        }

        return recommendMenus;
    }

    private Menu doRecommend(final Coach coach, final RecommendSystem recommendSystem) {

        boolean isTwoManyCategory = false;
        List<String> chosenMenus = new ArrayList<>();
        MenuCategory category;
        do {
            category = recommendSystem.pickRandomCategory();
            chosenMenus = menuRepository.getMenus(category);
            isTwoManyCategory = coach.isTooManySameCategory(chosenMenus);
        } while (isTwoManyCategory);


        final String menuName = recommendSystem.pickRandomMenu(chosenMenus, coach);
        return new Menu(category, menuName);
    }
}
