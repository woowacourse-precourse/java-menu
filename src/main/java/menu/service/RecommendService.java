package menu.service;

import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.DayWeek;

import java.util.List;

public class RecommendService {
    private final MenuService menuService;
    private final CategoryService categoryService = new CategoryService();

    private final RecommendResultService recommendResultService = new RecommendResultService();

    public RecommendService(MenuService menuService) {
        this.menuService = menuService;
    }

    public void recommend(DayWeek dayWeek, List<Coach> coaches) {
        for (Coach coach : coaches) {
            Category findCategory = categoryService.getRecommendCategory();
            while(!categoryService.isSaveCategoryInfo(findCategory)) {
                findCategory = categoryService.getRecommendCategory();
            }
            recommendResultService.saveCategoryResult(dayWeek, findCategory);
            String recommendMenu = menuService.getRecommendMenu(findCategory);
            boolean isAlreadyRecommend = menuService.isAlreadyRecommend(coach, recommendMenu);
            boolean isNotEatFood = coach.isNotEatFood(recommendMenu);
            while(isAlreadyRecommend || isNotEatFood) {
                recommendMenu = menuService.getRecommendMenu(findCategory);
                isAlreadyRecommend = menuService.isAlreadyRecommend(coach, recommendMenu);
                isNotEatFood = coach.isNotEatFood(recommendMenu);
            }
            recommendResultService.createAndSaveResult(coach, dayWeek, recommendMenu);
        }
    }

    public void getRecommendResult(List<Coach> coaches) {
        recommendResultService.getRecommendResult(coaches);
    }
}
