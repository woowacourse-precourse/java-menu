package menu.domain.menu;

import java.util.List;
import menu.domain.coach.Coach;
import menu.domain.coach.Coaches;
import menu.domain.results.RecommendCategories;

public class MenuService {
    private final MenuRepository menuRepository;

    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    public void addCoachAvoidMenu(Coach coach, List<String> menuNames) {
        for (String menuName : menuNames) {
            Menu menu = menuRepository.findByMenuName(menuName);
            coach.addAvoidMenu(menu);
        }
    }

    public void recommendMenus(Coaches coaches) {
        getRandomCategories();
    }

    public RecommendCategories getRandomCategories() {
        RecommendCategories recommendCategories = new RecommendCategories();
        while (!recommendCategories.isFull()) {
            MenuCategory menuCategory = MenuCategory.pickRandomMenuCategory();
            recommendCategories.addRecommendCategory(menuCategory);
        }

        return recommendCategories;
    }
}
