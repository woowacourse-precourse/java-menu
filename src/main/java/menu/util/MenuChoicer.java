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

//TODO : BUG FIX

//        for(FoodCategory foodCategory : weekFoodCategories){
//            String pickedMenu = "";
//            do{
//                pickedMenu = Randoms.shuffle(FoodCategory.getAllMenus()).get(0);
//            }while (foodCategory.getMenus().contains(pickedMenu));
//
//            menus.add(pickedMenu);
//        }


        return menus;
    }
}
