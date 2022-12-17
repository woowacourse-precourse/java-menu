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

}
