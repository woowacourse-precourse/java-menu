package menu.domain.menu;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class MenuRepositoryTest {

    private final MenuRepository menuRepository = new MenuRepository();
    @Test
    public void 이름으로_음식_조회_테스트() {
        String menuName = "김치찌개";

        Menu byMenuName = menuRepository.findByMenuName(menuName);
        Assertions.assertThat(byMenuName.getName()).isEqualTo(menuName);
    }

    @RepeatedTest(100)
    @Test
    public void 카테고리로_음식_랜덤_조회_테스트() {
        MenuCategory expectedCategory = MenuCategory.CHINESE;
        Menu byCategory = menuRepository.findRandomNameByCategory(expectedCategory);

        Assertions.assertThat(byCategory.matchCategory(expectedCategory)).isTrue();
    }



}