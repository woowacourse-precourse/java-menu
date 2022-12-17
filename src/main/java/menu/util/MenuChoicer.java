package menu.util;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.FoodCategory;
import menu.domain.Week;

import java.util.ArrayList;
import java.util.List;

public class MenuChoicer {

    public static List<String> makeWeekMenus(List<FoodCategory> weekFoodCategories){

        int totalDay = Week.values().length;

        List<String> menus = new ArrayList<>(totalDay);

        for(FoodCategory category : weekFoodCategories){
            menus.add(Randoms.shuffle(List.copyOf(category.getMenus())).get(0));
        }

        return menus;

    }
}
