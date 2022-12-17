package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class MenuRecommendService {
    private final List<Category> categories = Category.getCategories();
    private final List<Week> weeks = Week.getWeeks();

    private final List<Category> recommendedCategories = new ArrayList<>();

    public void recommendCategory() {
        HashMap<Category, Integer> categoryNum = makeCategoryAppearMap();
        for (int i = 0; i < weeks.size(); i++) {
            Category category = categories.get(Randoms.pickNumberInRange(1, 5) - 1);
            if (categoryNum.get(category) == 2) {
                i--;
                continue;
            }
            recommendedCategories.add(category);
            categoryNum.put(category,categoryNum.get(category)+1);
        }
    }

    private HashMap<Category,Integer> makeCategoryAppearMap() {
        HashMap<Category,Integer> categoryNum = new HashMap<>();
        for (Category category:
             categories) {
            categoryNum.put(category,0);
        }
        return categoryNum;
    }

}
