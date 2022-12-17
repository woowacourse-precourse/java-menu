package menu.domain.menu;

import java.util.List;
import menu.domain.results.RecommendCategories;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class MenuServiceTest {
    private MenuService menuService;

    @BeforeEach
    void beforeEach() {
        MenuRepository menuRepository = new MenuRepository();
        menuService = new MenuService(menuRepository);
    }


    @RepeatedTest(100)
    @Test
    public void 카테고리_추천_테스트() {
        RecommendCategories randomCategories = menuService.getRandomCategories();

        List<MenuCategory> categories = randomCategories.getCategories();
        Assertions.assertThat(categories).hasSize(5);

        Assertions.assertThat(categories.stream().distinct().count()).isGreaterThan(2);
    }

}