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
    private static final int FIRST = 1;

    private final MenuRepository menuRepository;
    private final RecommendSystem recommendSystem;

    public RecommendService() {
        this.menuRepository = new MenuRepository();
        this.recommendSystem = new RecommendSystem();
    }

    public List<RecommendResult> findRecommendMenus(final Coaches coaches) {

        final List<MenuCategory> categories = recommendSystem.pickRandomCategory();

        List<RecommendResult> results = new ArrayList<>();
        doRecommend(coaches, categories, results);

        return results;
    }

    private void doRecommend(final Coaches coaches, final List<MenuCategory> categories, final List<RecommendResult> results) {
        int count = 0;
        for (MenuCategory category : categories) {
            count++;
            recommendSameDay(results, coaches, count, category);
        }
    }

    private void recommendSameDay(final List<RecommendResult> results, final Coaches coaches, final int count, final MenuCategory category) {
        final int coachSize = coaches.getCoaches().size();

        for (int index = 0; index < coachSize; index++) {
            final Coach coach = coaches.getCoaches().get(index);
            final List<String> menus = menuRepository.getMenus(category);
            String menuName = recommendUntilSuccess(coach, menus);

            makeResult(results, count, category, index, coach, menuName);
        }
    }

    private static void makeResult(
            final List<RecommendResult> results,
            final int count,
            final MenuCategory category,
            final int index,
            final Coach coach,
            final String menuName
    ) {
        if (count == FIRST) {
            makeResultAndAddMenu(results, category, coach, menuName);
            return;
        }

        addMenu(results, category, index, menuName);
    }

    private static void makeResultAndAddMenu(final List<RecommendResult> results, final MenuCategory category, final Coach coach, final String menuName) {
        final Menu menu = new Menu(category, menuName);
        RecommendResult result = new RecommendResult(coach, makeRecommendMenus(menu));

        results.add(result);
    }

    private static List<Menu> makeRecommendMenus(final Menu menu) {
        List<Menu> recommendMenus = new ArrayList<>();
        recommendMenus.add(menu);

        return recommendMenus;
    }

    private static void addMenu(final List<RecommendResult> results, final MenuCategory category, final int j, final String menuName) {
        results.get(j).addMenu(new Menu(category, menuName));
    }

    private String recommendUntilSuccess(final Coach coach, final List<String> menus) {
        boolean canNotRecommend = false;
        String menuName = "";
        do {
            menuName = recommendSystem.pickRandomMenu(menus, coach);
            canNotRecommend = coach.validateMenu(menuName);
        } while (canNotRecommend);
        return menuName;
    }
}