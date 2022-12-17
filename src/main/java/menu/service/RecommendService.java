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
        Category findCategory = categoryService.getRecommendCategory();
        findCategory = checkCategoryAlreadySave(findCategory);
        for (Coach coach : coaches) {
            recommendResultService.saveCategoryResult(dayWeek, findCategory);
            String recommendMenu = menuService.getRecommendMenu(findCategory);
            recommendMenu = checkMenuAlreadyRecommend(findCategory, coach, recommendMenu);
            recommendMenu = checkMenuNotEatFood(findCategory, coach, recommendMenu);
            recommendResultService.createAndSaveResult(coach, dayWeek, recommendMenu);
        }
    }

    private String checkMenuNotEatFood(Category findCategory, Coach coach, String recommendMenu) {
        boolean isNotEatFood = coach.isNotEatFood(recommendMenu);
        while (isNotEatFood) {
            recommendMenu = menuService.getRecommendMenu(findCategory);
            isNotEatFood = coach.isNotEatFood(recommendMenu);
        }
        return recommendMenu;
    }

    private String checkMenuAlreadyRecommend(Category findCategory, Coach coach, String recommendMenu) {
        boolean isAlreadyRecommend = menuService.isAlreadyRecommend(coach, recommendMenu);
        while (isAlreadyRecommend) {
            recommendMenu = menuService.getRecommendMenu(findCategory);
            isAlreadyRecommend = menuService.isAlreadyRecommend(coach, recommendMenu);
        }
        return recommendMenu;
    }

    private Category checkCategoryAlreadySave(Category findCategory) {
        boolean isSave = categoryService.isSaveCategoryInfo(findCategory);
        while (!isSave) {
            findCategory = categoryService.getRecommendCategory();
            isSave = categoryService.isSaveCategoryInfo(findCategory);
        }
        return findCategory;
    }

    public String getRecommendResult(List<Coach> coaches) {
        String categoryResult = recommendResultService.getRecommendCategory();
        return categoryResult + recommendResultService.getRecommendResult(coaches);
    }
}
