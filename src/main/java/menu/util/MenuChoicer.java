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

        for(FoodCategory foodCategory : weekFoodCategories){

            List<String> menusByFoodCategory = new ArrayList<>(foodCategory.getMenus());

            String menu = Randoms.shuffle(menusByFoodCategory).get(0);

            menus.add(menu);
        }


        return menus;
    }
}
