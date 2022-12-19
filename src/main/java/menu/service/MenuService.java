package menu.service;

import menu.domain.RecommendCategoryInfo;
import menu.domain.CategoryMenu;
import menu.domain.CoachInfo;
import menu.domain.CoachMenuRecommendInfo;
import menu.util.CategorySelector;

import java.util.List;

public class MenuService {
    private final RecommendCategoryInfo recommendedCategoryInfo = new RecommendCategoryInfo();
    private final CoachMenuRecommendInfo coachMenuRecommendInfo = new CoachMenuRecommendInfo();
    private final CategorySelector categorySelector = new CategorySelector();

    private final int DAY_COUNT = 5;

    public void recommendMenu(CoachInfo coachInfo) {
        int oneWeek = DAY_COUNT;
        while (oneWeek-- > 0) {
            CategoryMenu category = pickPossibleCategory();
            for (String coachName : coachInfo.getCoachNames()) {
                String menu = pickPossibleMenu(category, coachName, coachInfo);
                coachMenuRecommendInfo.recommendMenu(coachName, menu);
            }
            recommendedCategoryInfo.saveCategoryInfoPerDay(category);
        }
    }

    public List<CategoryMenu> getRecommendedCategoryPerDay() {
        return recommendedCategoryInfo.getCategoryRecommendedInfo();
    }

    public List<String> getRecommendedMenus(String coachName) {
        return coachMenuRecommendInfo.getRecommendedMenuPerCoach(coachName);
    }

    private CategoryMenu pickPossibleCategory() {
        CategoryMenu category = findPossibleCategory();
        if (recommendedCategoryInfo.isPossibleCategory(category)) {
            return category;
        }
        return pickPossibleCategory();
    }

    private CategoryMenu findPossibleCategory() {
        CategoryMenu category = categorySelector.pickCategory();
        if (recommendedCategoryInfo.isPossibleCategory(category)) {
            return category;
        }
        return findPossibleCategory();
    }

    private String pickPossibleMenu(CategoryMenu category, String coachName, CoachInfo coachInfo) {
        String menu = categorySelector.pickMenu(category);
        if (coachMenuRecommendInfo.isPossibleMenu(coachName, menu) && !coachInfo.isForbiddenMenu(coachName,menu)) {
            return menu;
        }
        return pickPossibleMenu(category, coachName, coachInfo);
    }
}
