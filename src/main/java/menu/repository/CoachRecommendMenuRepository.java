package menu.repository;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import menu.domain.Categories;
import menu.domain.CoachExcludeMenu;
import menu.domain.CoachRecommendMenu;
import menu.domain.RecommendMenu;
import menu.domain.enums.Category;
import menu.domain.enums.Menu;

public class CoachRecommendMenuRepository {
    public static final int FIRST_MENU = 0;
    private static final CoachRecommendMenuRepository instance = new CoachRecommendMenuRepository();
    private static final List<CoachRecommendMenu> store = new ArrayList<>();

    private CoachRecommendMenuRepository() {
    }

    public static List<CoachRecommendMenu> generateMenusByCategories(
            final Categories categories,
            final List<CoachExcludeMenu> coachExcludeMenus) {
        store.addAll(coachExcludeMenus.stream()
                .map(coachExcludeMenu -> createCoachMenuByCategories(categories, coachExcludeMenu))
                .collect(Collectors.toList()));
        return findAll();
    }

    private static List<CoachRecommendMenu> findAll() {
        return Collections.unmodifiableList(store);
    }

    private static CoachRecommendMenu createCoachMenuByCategories(final Categories categories,
                                                                  final CoachExcludeMenu coachExcludeMenu) {
        List<String> coachMenus = new ArrayList<>();
        for (Category category : categories.getCategories()) {
            List<String> menuNames = category.getMenuList()
                    .stream()
                    .map(Menu::getName)
                    .collect(Collectors.toList());
            generateRandomMenu(coachExcludeMenu, coachMenus, menuNames);
        }
        return new CoachRecommendMenu(coachExcludeMenu.getCoach(), new RecommendMenu(coachMenus));
    }

    private static void generateRandomMenu(
            final CoachExcludeMenu coachExcludeMenu,
            final List<String> coachMenus,
            final List<String> menuNames) {
        while (true) {
            List<String> shuffleMenu = Randoms.shuffle(menuNames);
            if (!coachMenus.contains(shuffleMenu.get(FIRST_MENU)) && coachExcludeMenu.isPossibleToEat(
                    shuffleMenu.get(FIRST_MENU))) {
                coachMenus.add(shuffleMenu.get(FIRST_MENU));
                return;
            }
        }
    }
}
