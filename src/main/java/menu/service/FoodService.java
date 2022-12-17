package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FoodService {

    public void initialize() {
        forEveryCategory();
    }

    public void forEveryCategory() {
        for (Category category : CategoryRepository.categories()) {     // 각 요일별 카테고리
            forEveryCoach(category);
        }
    }

    public void forEveryCoach(Category category) {
        for (Coach coach : CoachRepository.coaches()) {
            addCoachRecommendFood(coach, category);
        }
    }


    public void addCoachRecommendFood(Coach coach, Category category) {
        while (true) {
            List<String> menus = category.getFoods();                   // 해당 카테고리의 음식들 중
            String menu = Randoms.shuffle(menus).get(0);                // 셔플해서 첫 음식
            if (!coach.containsInedibleFood(menu) && !coach.containsRecommendedFood(menu)) {
                coach.addRecommendedFood(menu);
                break;
            }
        }
    }




}
