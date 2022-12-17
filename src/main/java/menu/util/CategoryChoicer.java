package menu.util;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.FoodCategory;
import menu.domain.Week;

import java.util.ArrayList;
import java.util.List;

public class CategoryChoicer {

    public static List<FoodCategory> makeWeekCategories(){

        int totalDay = Week.values().length;

        List<FoodCategory> foodCategories = new ArrayList<>(totalDay);

        for(int day=0; day<totalDay; day++){
            foodCategories.add(
                    FoodCategory.getFoodCategoryByCode(
                            String.valueOf(Randoms.pickNumberInRange(1, 5))
                    ));
        }

        return foodCategories;

    }
}
