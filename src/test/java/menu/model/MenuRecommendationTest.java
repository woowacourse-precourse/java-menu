package menu.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MenuRecommendationTest {
    @DisplayName("2개를 초과하여 중복된 카테고리가 존재하지 않는다.")
    @Test
    public void notExistInExcessOfTwoCategories() {
        MenuRecommendation recommendation = new MenuRecommendation();
        List<Category> recommendedCategories = recommendation.getRandomCategories();
        List<Category> categories = Arrays.asList(Category.values());

        for (int i = 0; i < categories.size(); i++) {
            Category category = categories.get(i);

            Assertions.assertThat(recommendedCategories.stream()
                            .filter(s -> s.equals(category))
                            .count())
                    .isLessThanOrEqualTo(2);
        }
    }
}