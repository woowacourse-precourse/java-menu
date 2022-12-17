package menu.domain.service;

import menu.domain.model.Category;
import menu.domain.model.Coach;
import menu.domain.model.Menu;
import menu.domain.repository.CoachRepository;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MenuRecommendServiceTest {

    @Test
    void 코치들의_이름과_못먹는음식의_주어지면_생성하는_기능() {
        List<Menu> menu1 = List.of(
                new Menu(Category.JAPAN_FOOD, "우동"),
                new Menu(Category.JAPAN_FOOD, "스시")
        );
        List<Menu> menu2 = List.of(
                new Menu(Category.EUROPE_FOOD, "뇨끼"),
                new Menu(Category.ASIA_FOOD, "월남쌈")
        );
        List<Menu> menu3 = List.of(
                new Menu(Category.CHINA_FOOD, "마파두부"),
                new Menu(Category.CHINA_FOOD, "고추잡채")
        );

        Coach tomi = new Coach("토미", menu1);
        Coach james = new Coach("제임스", menu2);
        Coach poco = new Coach("포코", menu3);

        CoachRepository.save(tomi);
        CoachRepository.save(james);
        CoachRepository.save(poco);

        assertThat(CoachRepository.findAll().size()).isEqualTo(3);
    }
}