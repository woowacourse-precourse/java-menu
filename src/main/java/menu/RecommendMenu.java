package menu;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import menu.coach.Coach;
import menu.coach.Coaches;

public class RecommendMenu {

    private List<String> categoryOrder = new ArrayList<>();
    private List<Coach> coaches = Coaches.getCoaches();

    public RecommendMenu() {
        makeCategoryList();
    }

    public void makeCategoryList() {
        while (categoryOrder.size() < 5) {
            categoryOrder.add(validAdd());
        }
    }

    public List<String> getCategory() {
        return categoryOrder;
    }

    private String validAdd() {
        String category = Category.from(String.valueOf(Randoms.pickNumberInRange(1, 5))).name();
        if (countContains(category) >= 2) {
            return validAdd();
        }
        return category;
    }

    private int countContains(String input) {
        int count = 0;
        for (String category : categoryOrder) {
            if (category.equals(input)) {
                count += 1;
            }
        }
        return count;
    }

    public String[][] getResult() {
        String arr[][] = new String[Coaches.getCoaches().size()][6];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < coaches.size(); j++) {
                if (i == 0) {
                    arr[j][i] = coaches.get(j).getName();
                }
                arr[j][i + 1] = (recommendForOneDay(categoryOrder.get(i), coaches.get(j)));
            }
        }
        return arr;
    }

    private String recommendForOneDay(String category, Coach coach) {
        List<String> hateFood = coach.getHateFood();
        Menu menu = Menus.getMenuByCategory(category);
        List<String> recommendFoods = new ArrayList<>();
        return (validAddFood(menu.getFood(), recommendFoods, hateFood));
    }

    private String validAddFood(String food, List<String> recommendFoods, List<String> hateFood) {
        if (recommendFoods.contains(food) || hateFood.contains(food)) {
            return validAddFood(food, recommendFoods, hateFood);
        }
        return food;
    }
}
