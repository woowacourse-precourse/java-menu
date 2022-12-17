package menu.Controller;

import camp.nextstep.edu.missionutils.Randoms;
import menu.Domain.Categories;
import menu.Domain.Category;
import menu.Domain.Coach;
import menu.Domain.CoachRepository;
import menu.Domain.MenuRepository;

public class RecommendationController {

    private static final int MONDAY = 0;
    private static final int FRIDAY = 4;
    public static void run() {
        runCategoryRecommendation();
        runMenuRecommendation();
    }

    private static void runCategoryRecommendation() {
        for (int day = MONDAY; day <= FRIDAY; day++) {
            String category = Category.get(Randoms.pickNumberInRange(1, 5));
            Categories.addCategory(category);
        }
        if (!Categories.validateCategory()) {
            Categories.clear();
            runCategoryRecommendation();
        }
    }

    private static void runMenuRecommendation() {
        for (String category : Categories.getCategories()) {
            recommendMenu(category);
        }
        if (!validateMenus()) {
            CoachRepository.clearMenuList();
            runMenuRecommendation();
        }
    }

    private static void recommendMenu(String category) {
        for (Coach coach : CoachRepository.getCoachList()) {
            String randomMenu = Randoms.shuffle(MenuRepository.getMenuListByCategory(category)).get(0);
            coach.addMenu(randomMenu);
        }
    }

    private static boolean validateMenus() {
        for (Coach coach : CoachRepository.getCoachList()) {
            if (coach.hasUnfavoredMenu() || coach.hasSameMenu()) {
                return false;
            }
        }
        return true;
    }
}
