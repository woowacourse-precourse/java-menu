package menu;

import camp.nextstep.edu.missionutils.Randoms;
import constant.Category;
import constant.Week;
import repository.MenuForWeekRepository;

import java.util.List;

public class MenuRecommender {

    public static void addRecommendMenus(List<Coach> coaches) {
        for (Week weekday : Week.values()) {
            Category category = getRecommendCategory();
        }
    }

    private static Category getRecommendCategory() {
        Category recommendCategory = Category.getCategoryByNumber(Randoms.pickNumberInRange(1, 5));
        checkCategoryDuplication(recommendCategory);
        return recommendCategory;
    }

    private static void checkCategoryDuplication(Category recommendCategory) {
        MenuForWeekRepository.isCategoryAvailableToAdd(recommendCategory);
    }
}
