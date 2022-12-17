package menu.recommendation;

import menu.model.Category;
import menu.model.Menu;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MenuGeneratorTest {
    MenuGenerator menuGenerator = new MenuGenerator();

    @DisplayName("메뉴 검증 테스트")
    @Test
    void 메뉴_검증_테스트() {
        List<String> dontEatMenus = Arrays.asList("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "제육볶음");
        assertThat(menuGenerator.validation(Arrays.asList(), dontEatMenus, Category.KOREAN))
                .isEqualTo("떡볶이");

    }
}