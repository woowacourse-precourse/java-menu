package menu.domain.menu;

import java.util.List;
import java.util.stream.Collectors;
import menu.domain.coach.Coaches;
import menu.domain.results.RecommendCategories;
import menu.domain.results.RecommendCoachMenu;
import menu.domain.results.RecommendResult;

public class MenuService {
    private final MenuRepository menuRepository;

    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }
    public List<Menu> getAllMenusByMenuNames(List<String> menuNames) {
        return menuRepository.findAllByMenuNames(menuNames);
    }

    public RecommendResult recommendMenus(Coaches coaches) {
        RecommendCategories recommendCategories = getRandomCategories();
        List<RecommendCoachMenu> coachMenus = coaches.getCoaches().stream()
                .map(RecommendCoachMenu::of)
                .collect(Collectors.toList());

        for (MenuCategory category : recommendCategories.getCategories()) {
            recommendMenuByCategory(category, coachMenus);
        }

        return RecommendResult.of(recommendCategories, coachMenus);
    }

    public RecommendCategories getRandomCategories() {
        RecommendCategories recommendCategories = new RecommendCategories();
        while (!recommendCategories.isFull()) {
            MenuCategory menuCategory = MenuCategory.pickRandomMenuCategory();
            recommendCategories.addRecommendCategory(menuCategory);
        }

        return recommendCategories;
    }

    private void recommendMenuByCategory(MenuCategory category, List<RecommendCoachMenu> coaches) {
        for (RecommendCoachMenu coachMenu : coaches) {
            recommendMenuByCategoryToCoach(category, coachMenu);
        }
    }

    private void recommendMenuByCategoryToCoach(MenuCategory category, RecommendCoachMenu coachMenu) {
        try {
            Menu menuByCategory = menuRepository.findRandomNameByCategory(category);
            coachMenu.addRecommendMenu(menuByCategory);
        } catch (IllegalStateException exception) {
            recommendMenuByCategoryToCoach(category, coachMenu);
        }
    }
}
