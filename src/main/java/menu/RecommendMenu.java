package menu;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import menu.coach.Coaches;

public class RecommendMenu {

    private final Coaches coaches;
    private List<String> categoryOrder = new ArrayList<>();

    public RecommendMenu(Coaches coaches) {
        this.coaches = coaches;
    }

    public void makeCategoryList() {
        while (categoryOrder.size() < 5) {
            categoryOrder.add(validAdd());
        }
        System.out.println(categoryOrder);
    }

    private String validAdd() {
        String category = Category.from(String.valueOf(Randoms.pickNumberInRange(1, 5))).name();
        if (categoryOrder.contains(category)) {
            return validAdd();
        }
        return category;
    }
}
