package menu.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;

class CategoryRecommendServiceTest {
    @Test
    @DisplayName("총 카테고리수 * 최대 중복 가능 횟수까지 추천했을 때, 각각 최대 중복 가능 횟수까지 추천되는지 확인")
    void recommendCategory_CallMaximum_TwoRecommendEach() {
        int categoryNum = 5;
        int maximumLimit = 2;
        Map<String, Integer> count = new HashMap<>();
        for (int i = 0; i < categoryNum * maximumLimit; i++) {
            String category = CategoryRecommendService.recommendCategory();
            if (!count.containsKey(category)) {
                count.put(category, 0);
            }
            count.put(category, count.get(category) + 1);
        }
        assertThat(count.keySet().stream().noneMatch((key) -> count.get(key) > maximumLimit)).isEqualTo(true);
    }
}