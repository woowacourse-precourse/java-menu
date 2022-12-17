package menu.domain;

import menu.domain.menucategory.MenuCategory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MenuCategoryTest {
    @DisplayName("카테고리 선택 횟수 제한")
    @Test
    void selectCountLimited() {
        MenuCategory menuCategory = MenuCategory.from("한식");
        menuCategory.select();
        menuCategory.select();

        Assertions.assertThat(menuCategory.canSelect()).isFalse();
    }

}
