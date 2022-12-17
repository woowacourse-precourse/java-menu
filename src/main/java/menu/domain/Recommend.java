package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import menu.Constant;
import menu.enums.FoodCategory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Recommend {
    private Map<FoodCategory, Integer>  weekCategoryChoose;
    private List<FoodCategory> weekCategory;

    public Recommend() {
        weekCategory = new ArrayList<>();
        initWeekCategoryChoose();
    }

    // 카테고리 추천 메서드
    public FoodCategory recommendCategory() {
        FoodCategory foodCategory;
        while (true) {
            foodCategory = FoodCategory.valueOfNumber(Randoms.pickNumberInRange(
                    Constant.weekLabelMin, Constant.weekLabelMax));
            if (checkIsValidFoodCategory(foodCategory) == true) {
                break;
            }
        }
        return foodCategory;
    }

    // weekCategory getter
    public List<FoodCategory> getWeekCategory() {
        return weekCategory;
    }


    // private
    // 이번주 두번 이상 먹지 않았는지 확인
    private boolean checkIsValidFoodCategory(FoodCategory foodCategory) {
        Integer categoryChooseNum = weekCategoryChoose.get(foodCategory);
        if (categoryChooseNum >= Constant.weekMaxCategory) {
            return false;
        }
        weekCategoryChoose.put(foodCategory,categoryChooseNum+1);
        weekCategory.add(foodCategory);
        return true;
    }

    // weekCategoryChoose 초기화
    private void initWeekCategoryChoose() {
        weekCategoryChoose = new HashMap<>();
        weekCategoryChoose.put(FoodCategory.KOR,0);
        weekCategoryChoose.put(FoodCategory.JAP,0);
        weekCategoryChoose.put(FoodCategory.CHI,0);
        weekCategoryChoose.put(FoodCategory.ASI,0);
        weekCategoryChoose.put(FoodCategory.WES,0);
    }
}
