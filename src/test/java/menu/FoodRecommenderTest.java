package menu;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


class FoodRecommenderTest {

    @Test
    void pickCategory() {
        FoodRecommender test = new FoodRecommender();
        for (int i = 0; i < 8; i++) {
            System.out.println(test.pickCategory());
        }
    }
}