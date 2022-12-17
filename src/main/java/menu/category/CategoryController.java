package menu.category;

import menu.coach.Coach;
import menu.coach.CoachController;
import menu.view.OutputView;

import java.util.List;

public class CategoryController {

    /**
     * 카테고리 & 메뉴 추천 실행
     */
    public static void recommendMenu() {
        CategoryService.recommendCategories();

        List<Coach> coaches = CoachController.getCoaches();
        for (Coach coach : coaches) {
            List<String> recommendMenusToCoach = CategoryService.setRecommendMenusToCoach(coach);
            coach.setMenusRecommended(recommendMenusToCoach);
        }
        OutputView.printRecommendResult(coaches);
    }

}
