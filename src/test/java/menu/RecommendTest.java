package menu;


import menu.domain.Recommend;
import menu.enums.FoodCategory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class RecommendTest {

    @DisplayName("한 주에 같은 '카테고리' 는 최대 2회까지만 인지 확인")
    @Test
    void 카테고리_최대_횟수_테스트() {
        // given
        Recommend recommend = new Recommend();
        for (int i = 0; i < Constant.weekNum; i++) {
            recommend.recommendCategory();
        }

        // when
        List<FoodCategory> weekCategory = recommend.getWeekCategory();
        Map<FoodCategory,Integer> weekCategoryNum = new HashMap<>();
        for (FoodCategory foodCategory : weekCategory) {
            if (weekCategoryNum.get(foodCategory) == null){
                weekCategoryNum.put(foodCategory,1);
                break;
            }
            weekCategoryNum.put(foodCategory,weekCategoryNum.get(foodCategory)+1);
        }

        boolean isMoreThanMaxCategory = weekCategoryNum.entrySet().stream()
                .anyMatch(v -> v.getValue() > Constant.weekMaxCategory);

        // then
        assertThat(isMoreThanMaxCategory).isFalse();
    }
}
