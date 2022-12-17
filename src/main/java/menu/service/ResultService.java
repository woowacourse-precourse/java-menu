package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import menu.domain.Category;
import menu.domain.Result;

public class ResultService {
    public Result initializeResult() {
        Map<String, Integer> categoryCounts = new HashMap<>();
        for (String categoryName : Category.getCategoryNames()) {
            categoryCounts.put(categoryName, 0);
        }
        return new Result(new ArrayList<>(), categoryCounts);
    }

    public void pickCategory(Result result) {
        String categoryName;
        do {
            int randomNumber = Randoms.pickNumberInRange(1, 5);
            categoryName = Category.convertNumberToName(randomNumber);
        } while (result.checkCategoryCount(categoryName) >= 2);
        result.addCategory(categoryName);
        result.increaseCategoryCount(categoryName);
    }
}
