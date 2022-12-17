package menu.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.in;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BannedFoodsTest {
    @Test
    @DisplayName("금지 음식 추가 테스트")
    public void addBannedFoodTest() {
        // given
        BannedFoods bannedFoods = new BannedFoods();
        String bannedFoodName = "우동";

        // when
        bannedFoods.addBannedFood(bannedFoodName);

        // then
        assertThat(bannedFoods.getBannedFoods().contains(bannedFoodName)).isEqualTo(true);
    }

    @Test
    @DisplayName("금지 음식 리스트 추가 테스트")
    public void addBannedFoodsTest() {
        // given
        BannedFoods bannedFoods = new BannedFoods();
        String input = "우동,스시";

        // when
        bannedFoods.addBannedFoods(input);

        // then
        assertThat(bannedFoods.getBannedFoods().size()).isEqualTo(2);
    }
}
