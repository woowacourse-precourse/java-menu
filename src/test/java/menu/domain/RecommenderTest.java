package menu.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import menu.constant.Category;
import menu.constant.Food;

class RecommenderTest {

    private static final int TWICE = 2;

    @Test
    void 코치는_2_이상_5이하_명이다() {
        assertThatNoException().isThrownBy(() -> new Recommender(createCoaches(2)));
    }

    @Test
    void 코치가_너무_적으면_예외를_던진다() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Recommender(createCoaches(1)));
    }

    @Test
    void 코치가_너무_많으면_예외를_던진다() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Recommender(createCoaches(6)));
    }

    @RepeatedTest(1000)
    void 같은_카테고리는_두번_까지만() {
        List<Coach> coaches = createCoaches(3);
        Recommender recommender = new Recommender(coaches);
        recommender.recommend();

        for (Coach c : coaches) {
            List<Food> recommendedFoods = c.getRecommendedFoods();
            List<Category> categories = getCategoriesOf(recommendedFoods);
            assertThat(hasAnyMoreThanTwice(categories)).isFalse();
        }
    }

    private List<Category> getCategoriesOf(List<Food> recommendedFoods) {
        return recommendedFoods.stream()
                .map(Food::getCategory)
                .collect(Collectors.toList());
    }

    private List<Coach> createCoaches(int number) {
        Supplier<Coach> coachSupplier = () -> new Coach("이름", List.of());
        List<Coach> coaches = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            coaches.add(coachSupplier.get());
        }
        return coaches;
    }

    private boolean hasAnyMoreThanTwice(List<Category> fromCategories) {
        for (Category category : Category.values()) {
            if (hasMoreThanTwice(fromCategories, category)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasMoreThanTwice(List<Category> fromCategories, Category targetCategory) {
        long count = fromCategories.stream()
                .filter(category -> category.equals(targetCategory))
                .count();
        return count > TWICE;
    }

}