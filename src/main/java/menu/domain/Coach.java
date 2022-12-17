package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.menu.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static menu.constant.Constants.*;

public class Coach {
    private String coachName;

    private Set<String> cantEatingFoodName;

    private List<String> foodPerDate;

    public Coach(String name) {
        this.coachName = name;
        this.cantEatingFoodName = new HashSet<>();
        this.foodPerDate = new ArrayList<>();
    }

    public void addCantEatingFood(List<String> foodNames) {
        for (int i = 0; i < foodNames.size(); i++) {
            cantEatingFoodName.add(foodNames.get(i));
        }
    }

    public void addFood(FoodCategory foodCategory) {
        SpecificMenu specificMenu = getSpecificMenu(foodCategory);
        String menu = Randoms.shuffle(specificMenu.getFoodsList()).get(0);

        while (foodPerDate.contains(menu) || cantEatingFoodName.contains(menu)) {
            menu = Randoms.shuffle(specificMenu.getFoodsList()).get(0);
        }
        foodPerDate.add(menu);
    }


    public SpecificMenu getSpecificMenu(FoodCategory foodCategory) {
        SpecificMenu specificMenu = null;
        if (foodCategory == FoodCategory.JAPANESE) {
            specificMenu = new JapaneseMenu();
        } else if (foodCategory == FoodCategory.KOREAN) {
            specificMenu = new KoreanMenu();
        } else if (foodCategory == FoodCategory.CHINESE) {
            specificMenu = new ChineseMenu();
        } else if (foodCategory == FoodCategory.ASIAN) {
            specificMenu = new AsianMenu();
        } else if (foodCategory == FoodCategory.ITALIAN) {
            specificMenu = new ItalianMenu();
        }
        return specificMenu;
    }

    public String toStringCoach() {
        return START_BRACKET + " " + coachName + STICK + foodPerDate.get(0) + STICK + foodPerDate.get(1) + STICK + foodPerDate.get(2) + STICK + foodPerDate.get(3) + STICK + foodPerDate.get(4)  + END_BRACKET +'\n';
    }
}
