package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import menu.enums.FoodCategory;
import menu.vo.Coach;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Recommend {
    private Map<FoodCategory, Integer>  weekCategoryChoose;
    private Map<Coach,List<String>> coachEatenMenu;

    public Recommend(List<Coach> coaches) {
        initWeekCategoryChoose();
        initCoachEatenMenu(coaches);
    }

    public void chooseMenu() {
        FoodCategory foodCategory = recommendFoodCategory();


    }

    private FoodCategory recommendFoodCategory() {
        FoodCategory foodCategory;
        while (true) {
            foodCategory = FoodCategory.valueOfNumber(Randoms.pickNumberInRange(1, 5));
            if (checkIsValidFoodCategory(foodCategory) == true) {
                break;
            }
        }
        return foodCategory;
    }

    private boolean checkIsValidFoodCategory(FoodCategory foodCategory) {
        Integer categoryChooseNum = weekCategoryChoose.get(foodCategory);
        if (categoryChooseNum > 2) {
            return false;
        }
        weekCategoryChoose.put(foodCategory,categoryChooseNum+1);
        return true;
    }

    private void initWeekCategoryChoose() {
        weekCategoryChoose.put(FoodCategory.KOR,0);
        weekCategoryChoose.put(FoodCategory.JAP,0);
        weekCategoryChoose.put(FoodCategory.CHI,0);
        weekCategoryChoose.put(FoodCategory.ASI,0);
        weekCategoryChoose.put(FoodCategory.WES,0);
    }

    private void initCoachEatenMenu(List<Coach> coaches) {
        for (Coach coach : coaches) {
            coachEatenMenu.put(coach,new ArrayList<>());
        }
    }
}
