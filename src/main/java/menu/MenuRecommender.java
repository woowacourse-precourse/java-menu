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
        Category recommendCategory;
        while (true) {
            recommendCategory = Category.getCategoryByNumber(Randoms.pickNumberInRange(1, 5));
            if (MenuForWeekRepository.isCategoryAvailableToAdd(recommendCategory)) {
                break;
            }
        }
        return recommendCategory;
    }

}
