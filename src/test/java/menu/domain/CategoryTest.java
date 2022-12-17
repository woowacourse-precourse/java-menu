package menu.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CategoryTest {
    @DisplayName("카테고리에 따른 메뉴를 확인한다.")
    @Test
    void checkCategoryMenu() {
        assertThat(Category.getWantCategoryMenu(5))
                .isEqualTo(List.of("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니"));
    }

    @DisplayName("카테고리에 따른 이름을 확인한다.")
    @Test
    void checkCategoryName() {
        assertThat(Category.getWantCategoryName(5))
                .isEqualTo("양식");
    }

}
