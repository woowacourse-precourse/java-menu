package menu.domain.service;

import menu.domain.dto.RecommendResultDto;
import menu.domain.model.Category;
import menu.domain.model.Coach;
import menu.domain.model.Menu;
import menu.domain.repository.CoachRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

class MenuRecommendServiceTest {

    private MenuRecommendService menuRecommendService;

    @BeforeEach
    void setUp() {
        menuRecommendService = new MenuRecommendService();
    }

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

    @Test
    void 한명의_코치의_메뉴추천_서비스() {
        List<Menu> menu1 = List.of(
                new Menu(Category.JAPAN_FOOD, "우동"),
                new Menu(Category.JAPAN_FOOD, "스시")
        );
        Coach tomi = new Coach("토미", menu1);
        TestCategoryStrategy testCategoryStrategy = new TestCategoryStrategy(newArrayList(1, 2, 3, 4, 5));
        TestMenuStrategy testMenuStrategy = new TestMenuStrategy(newArrayList("오코노미야끼", "김밥", "깐풍기", "분짜", "스파게티"));
        List<RecommendResultDto> resultDtos =
                menuRecommendService.recommendFood(tomi, testCategoryStrategy, testMenuStrategy);

        for (RecommendResultDto resultDto : resultDtos) {
            System.out.println(resultDto.getDay());
            System.out.println(resultDto.getCategory());
            System.out.println(resultDto.getMenu());
        }
    }
}