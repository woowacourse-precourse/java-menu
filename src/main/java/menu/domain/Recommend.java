package menu.domain;

import menu.enums.FoodCategory;
import menu.vo.Coach;
import menu.vo.Menu;

import java.util.List;
import java.util.Map;

public class Recommend {
    private Map<FoodCategory, Integer>  weekCategoryChoose;
    private Map<Coach,List<Menu>> coachEatenMenu;

    public Recommend(List<Coach> coaches) {
        
    }

    private void initWeekCategoryChoose() {
        weekCategoryChoose.put(FoodCategory.KOR,0);
        weekCategoryChoose.put(FoodCategory.JAP,0);
        weekCategoryChoose.put(FoodCategory.CHI,0);
        weekCategoryChoose.put(FoodCategory.ASI,0);
        weekCategoryChoose.put(FoodCategory.WES,0);
    }

    private void initCoachEatenMenu() {

    }
}
