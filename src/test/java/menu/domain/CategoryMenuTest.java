package menu.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

@DisplayName("카테고리, 카테고리에 해당하는 메뉴 정보가 있는 enum테스트")
class CategoryMenuTest {

    @Test
    void 메뉴는_카테고리에_존재하는_메뉴만_가능하다() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> CategoryMenu.validateMenuName("바나나"));
    }

    @Test
    void 숫자에_맞는_카테고리_반환_테스트() {
        org.assertj.core.api.Assertions.assertThat(CategoryMenu.getCategory(1))
                .isEqualTo(CategoryMenu.JAPAN_FOOD);
    }

    @Test
    void 카테고리에_맞는_메뉴_리스트_반환_테스트() {
        org.assertj.core.api.Assertions.assertThat(CategoryMenu.getMenus(CategoryMenu.KOREA_FOOD))
                .containsExactly("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음");
    }

    @Test
    void 원본_메뉴_리스트는_불변() {
        List<String> baseMenus = CategoryMenu.getMenus(CategoryMenu.KOREA_FOOD);
        baseMenus.set(0, "바나나");
        List<String> newMenus = CategoryMenu.getMenus(CategoryMenu.KOREA_FOOD);

        org.assertj.core.api.Assertions.assertThat(newMenus).doesNotContain("바나나");
    }
}