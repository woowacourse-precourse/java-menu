package menu;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import menu.coach.Coach;
import menu.coach.Coaches;

public class RecommendMenu {

    private List<String> categoryOrder = new ArrayList<>();
    private List<Coach> coaches = Coaches.getCoaches();

    public RecommendMenu() {
    }

    public void makeCategoryList() {
        while (categoryOrder.size() < 5) {
            categoryOrder.add(validAdd());
        }
    }

    private String validAdd() {
        String category = Category.from(String.valueOf(Randoms.pickNumberInRange(1, 5))).name();
        if (countContains(category) >= 2) {
            return validAdd();
        }
        return category;
    }

    private int countContains(String input) {
        int count = 0;
        for (String category : categoryOrder) {
            if (category.equals(input)) {
                count += 1;
            }
        }
        System.out.println(count);
        return count;
    }
}
