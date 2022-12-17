package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import menu.model.CategoryResult;
import menu.model.Coach;
import menu.model.RecommendResult;

import java.util.ArrayList;
import java.util.List;

public class MenuService {
    public RecommendResult recommendMenu(List<Coach> coachList) {
        CategoryResult categoryResult = recommendCategory();
        return null;
    }

    public CategoryResult recommendCategory() {
        int categoryPool[] = new int[6];
        for (int i = 1; i <= 5; i++) {
            categoryPool[i] = 2;
        }
        int selected = 0;
        List<String> categoryResult = new ArrayList<>();
        while (selected != 5) {
            int i = Randoms.pickNumberInRange(1, 5);
            if (categoryPool[i] > 0) {
                selected++;
                categoryResult.add(convertCategoryNumberToString(i));
            }
        }
        return new CategoryResult(categoryResult);
    }

    public String convertCategoryNumberToString(int i) {
        if (i == 1) {
            return "일식";
        } else if (i == 2) {
            return "한식";
        } else if (i == 3) {
            return "중식";
        } else if (i == 4) {
            return "아시안";
        } else if (i == 5) {
            return "양식";
        }
        return "error";
    }
}
