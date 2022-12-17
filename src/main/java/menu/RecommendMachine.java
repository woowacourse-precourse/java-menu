package menu;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RecommendMachine {

    public void recommend(Category category, Coach coach) {
        boolean decideNotYet = true;

        while (decideNotYet) {
            List<String> categoryToFoods = Randoms.shuffle(category.getFoods());
            String selectFood = categoryToFoods.get(0);

            if (!coach.isHateFood(selectFood) && coach.isPossibleRecommendFood(selectFood)) {
                coach.recommendFood(selectFood);
                decideNotYet = false;
            }
        }
    }
}
