package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import menu.domain.Ban;
import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Menus;
import menu.domain.Result;

public class ResultService {
    public Result initializeResult(Coach coach) {
        Map<String, Integer> categoryCounts = new HashMap<>();
        Map<String, ArrayList<String>> selectedMenu = new HashMap<>();

        for (String categoryName : Category.getCategoryNames()) {
            categoryCounts.put(categoryName, 0);
        }
        for (String coachName : coach.getCoachNames()) {
            selectedMenu.put(coachName, new ArrayList<>());
        }
        return new Result(new ArrayList<>(), categoryCounts, selectedMenu);
    }

    public String pickCategory(Result result) {
        String categoryName;
        do {
            int randomNumber = Randoms.pickNumberInRange(1, 5);
            categoryName = Category.convertNumberToName(randomNumber);
        } while (result.checkCategoryCount(categoryName) >= 2);
        result.addCategory(categoryName);
        result.increaseCategoryCount(categoryName);
        return categoryName;
    }

    public void pickMenu(String categoryName, Result result, String coach, Ban ban) {
        String menu;
        do {
            menu = Randoms.shuffle(Menus.parseMenuNames(categoryName)).get(0);
        } while (isSelectedMenu(result, coach, menu) || ban.isBanMenu(coach, menu));
        result.addMenu(coach, menu);
    }

    public boolean isSelectedMenu(Result result, String coach, String menuName) {
        for (String menu : result.checkSelectedMenu(coach)) {
            if (menu.equals(menuName)) {
                return true;
            }
        }
        return false;
    }
}
