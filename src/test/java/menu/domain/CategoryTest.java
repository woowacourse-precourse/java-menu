package menu.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CategoryTest {

    @DisplayName("메뉴 이름을 찾을 수 있는지 확인하다.")
    @Test
    void checkTrueFindByName() {
        // given
        String value = "우동";
        Category category = new Category("일식", List.of("규동", "우동", "미소시루", "스시"));
        boolean expected = true;

        // when
        boolean actual = category.findByName(value);

        // then
        assertEquals(actual, expected, "[ERROR] 카테고리 안에 메뉴가 있는데 없다고 나옵니다.");
    }

    @DisplayName("메뉴 이름을 찾을 수 없는지 확인하다.")
    @Test
    void checkFalseFindByName() {
        // given
        String value = "김치찌개";
        Category category = new Category("일식", List.of("규동", "우동", "미소시루", "스시"));
        boolean expected = false;

        // when
        boolean actual = category.findByName(value);

        // then
        assertEquals(actual, expected, "[ERROR] 카테고리 안에 메뉴가 없는데 있다고 나옵니다.");
    }
}
