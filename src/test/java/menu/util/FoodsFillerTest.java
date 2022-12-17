package menu.util;

import static menu.factory.CrewFactory.createCrew;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.ArrayList;
import java.util.List;
import menu.domain.Crew;
import menu.domain.menu.KoreanFood;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FoodsFillerTest {
    private FoodsFiller foodsFiller = new FoodsFiller();

    @Test
    @DisplayName("음식 하나씩 채우기 테스트")
    public void test() {
        // given
        Crew crew = createCrew("포비");
        String category = "한식";
        List<String> bannedFood = new ArrayList<>();
        List<String> koreanFoods = KoreanFood.any.getAllFoods();

        // when
        foodsFiller.fillFoods(crew, category, bannedFood);
        String result = crew.toString().substring(2).trim();

        // then
        assertThat(koreanFoods.contains(result)).isEqualTo(true);

    }
}
