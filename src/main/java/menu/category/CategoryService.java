package menu.category;

import menu.coach.Coach;
import menu.coach.CoachService;

import java.util.List;

public class CategoryService {

    public static void recommendMenu() {
        List<Coach> coaches = CoachService.getCoaches();
        // 못 먹는 메뉴 기반 랜덤 추천
        // coach.setRecommendedMenu()
    }

    // 존재하는 메뉴인지 확인
    public static boolean isInMenu(String coachCannotEat) {
        for (Category.Categories category : Category.Categories.values()) {
            List<String> menus = category.getMenus();
            for (String menu : menus) {
                if (menu.compareTo(coachCannotEat) == 0) {
                    return true;
                }
            }
        }
        return false;
    }

}
