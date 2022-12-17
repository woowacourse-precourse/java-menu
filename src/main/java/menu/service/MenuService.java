package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.Coach;
import menu.domain.Coaches;
import menu.domain.PickCategory;
import menu.utils.Category;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MenuService {

    private static final int MIN_CATEGORY_NUMBER = 1;
    private static final int MAX_CATEGORY_NUMBER = 5;
    private static final int MIN_WEEK_NUMBER = 0;
    private static final int MAX_WEEK_NUMBER = 5;

    public PickCategory recommendCategory() {
        return new PickCategory(makeCategory());
    }

    public void pickRecommendMenu(Coaches coaches, PickCategory pickCategory) {
        for (int weekend = MIN_WEEK_NUMBER; weekend < MAX_WEEK_NUMBER; weekend++) {
            for (Coach coach : coaches.getCoaches()) {
                pickRandomMenu(coach, weekend, pickCategory);
            }
        }
    }

    public void pickRandomMenu(Coach coach, int weekend, PickCategory pickCategory) {
        coach.getPickMenu().addPickMenu(pickCategory, coach.getNotEatableMenu(), weekend);
    }

    public List<Category> makeCategory() {
        boolean isDuplicate = true;
        List<Category> makeCategory = new ArrayList<>();
        while(isDuplicate) {
            makeCategory.clear();
            for (int i = 0; i < MAX_CATEGORY_NUMBER; i++) {
                Category category = Category.valueOfPickNumber(Randoms.pickNumberInRange(MIN_CATEGORY_NUMBER,MAX_CATEGORY_NUMBER));
                makeCategory.add(category);
            }
            isDuplicate = checkDuplicateFrequency(makeCategory);
        }
        return makeCategory;
    }

    private boolean checkDuplicateFrequency(List<Category> makeCategory) {
        if (Collections.frequency(makeCategory, Category.KOREA) > 2)
            return true;
        if (Collections.frequency(makeCategory, Category.JAPAN) > 2)
            return true;
        if (Collections.frequency(makeCategory, Category.CHINA) > 2)
            return true;
        if (Collections.frequency(makeCategory, Category.ASIA) > 2)
            return true;
        if (Collections.frequency(makeCategory, Category.WESTERN) > 2)
            return true;
        return false;
    }
}
