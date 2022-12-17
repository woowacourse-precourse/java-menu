package menu.domain.results;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import menu.domain.coach.Coach;
import menu.domain.menu.Menu;
import menu.domain.menu.MenuCategory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RecommendCoachMenuTest {
    @Test
    public void 동일한_음식은_추천_될_수_없다() {
        Coach coach = Coach.fromName("코치");
        RecommendCoachMenu recommendCoachMenu = RecommendCoachMenu.of(coach);
        Menu ramen = Menu.of("라멘", MenuCategory.JAPANESE);

        recommendCoachMenu.addRecommendMenu(ramen);

        Assertions.assertThatThrownBy(() -> recommendCoachMenu.addRecommendMenu(ramen))
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    public void 못_먹는_음식은_추천_될_수_없다() {
        Coach coach = Coach.fromName("코치");
        Menu ramen = Menu.of("라멘", MenuCategory.JAPANESE);
        coach.addAllAvoidMenu(List.of(ramen));

        RecommendCoachMenu recommendCoachMenu = RecommendCoachMenu.of(coach);

        Assertions.assertThatThrownBy(() -> recommendCoachMenu.addRecommendMenu(ramen))
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    public void 추천_메뉴_출력_테스트() {
        Coach coach = Coach.fromName("코치");
        RecommendCoachMenu recommendCoachMenu = RecommendCoachMenu.of(coach);

        recommendCoachMenu.addRecommendMenu(Menu.of("라멘", MenuCategory.JAPANESE));
        recommendCoachMenu.addRecommendMenu(Menu.of("우동", MenuCategory.JAPANESE));
        recommendCoachMenu.addRecommendMenu(Menu.of("김치찌개", MenuCategory.KOREAN));
        recommendCoachMenu.addRecommendMenu(Menu.of("카오 팟", MenuCategory.ASIAN));
        recommendCoachMenu.addRecommendMenu(Menu.of("스파게티", MenuCategory.FRENCH));

        String expectedFormat = "[ 코치 | 라멘 | 우동 | 김치찌개 | 카오 팟 | 스파게티 ]";
        String resultFormat = recommendCoachMenu.resultFormat();
        Assertions.assertThat(resultFormat).isEqualTo(expectedFormat);
    }


}