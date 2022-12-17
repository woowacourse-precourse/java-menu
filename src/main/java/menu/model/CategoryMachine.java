package menu.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CategoryMachine {

    public void selectCategory(Coach coach) {
        coach.setCategory(new ArrayList<>());
        List<Integer> category = coach.getCategory();

        while(category.size() != 5) {
            checkNumberOfSameCategory(category, Randoms.pickNumberInRange(1, 5));
        }
    }

    private void checkNumberOfSameCategory(List<Integer> category, int country) {
        if(Collections.frequency(category, country) >= MenuConstant.MAX_CATEGORY_NUMBER) {
            return;
        }
        category.add(country);
    }
}
