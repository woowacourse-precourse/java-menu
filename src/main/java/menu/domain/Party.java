package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static menu.constant.Constants.*;

public class Party {
    private List<Coach> coaches;
    private List<FoodCategory> foodCategories;


    public Party() {
        this.coaches = new ArrayList<>();
        this.foodCategories = new ArrayList<>();
    }

    public void setFoodCategories() {
        int[] checkCount = new int[6];
        for(int i = 1; i <= 5; i++) {
            int category = Randoms.pickNumberInRange(1, 5);
            if(checkCount[category] < 2) {
                foodCategories.add(FoodCategory.categoryNumberToFoodCategory(category));
                checkCount[category]++;
            } else if (checkCount[category] >= 2) {
                i--;
            }
        }
    }
    public void addCoaches(List<String> coachNames) {
        for (int i = 0; i < coachNames.size(); i++) {
            coaches.add(new Coach(coachNames.get(i)));
        }
    }

    public void addCoachesCantEatingFood(List<String> cantFoodName) {
        Coach coach;
        for (int i = 0; i < coaches.size(); i++) {
            coach = coaches.get(i);
            coach.addCantEatingFood(cantFoodName);
        }
    }

    public void addFoodPerCoach() {
        Coach coach;
        for (int i = 0; i < coaches.size(); i++) {
            coach = coaches.get(i);
            for(int j = 0; j< foodCategories.size(); j++) {
                coach.addFood(foodCategories.get(j));
            }
        }
    }

    public String recommendResult() {
        StringBuilder stringBuilder = new StringBuilder();
        Coach coach;
        for(int i = 0; i< coaches.size(); i++) {
            coach = coaches.get(i);
            stringBuilder.append(coach.toStringCoach());
        }
        return stringBuilder.toString();
    }

    public String toStringFoodCategories() {
        return START_BRACKET + "카테고리" + STICK + foodCategories.get(0).getCategoryName() + STICK + foodCategories.get(1).getCategoryName() + STICK + foodCategories.get(2).getCategoryName() + STICK + foodCategories.get(3).getCategoryName() + STICK + foodCategories.get(4).getCategoryName() + END_BRACKET;
    }

}
