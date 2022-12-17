package menu.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MenuTest {
    @BeforeAll
    void setUp() {
        Map<Category, List<String>> cache = Map.of(
                Category.JAPAN, List.of("규동", "우동"),
                Category.KOREA, List.of("김밥", "김치찌개"),
                Category.CHINA, List.of("깐풍기"),
                Category.ASIAN, List.of("팟타이"),
                Category.WESTERN, List.of("라자냐")
        );

        Menu.initialize(cache);
    }

    @Test
    void 입력된_이름에_해당하는_객체_반환() {
        String name = "규동";
        Menu expected = Menu.valueOf(name);

        assertThat(name).isEqualTo(expected.getName());
    }

    @Test
    void 잘못된_이름이면_예외_발생() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Menu.valueOf("오야꼬동"));
    }

    @Test
    void 일식_메뉴_리스트_반환() {
        List<Menu> expected = List.of(
                Menu.valueOf("규동"),
                Menu.valueOf("우동")
        );

        List<Menu> actual = Menu.getMenusOfCategory(Category.JAPAN);

        assertThat(actual).isEqualTo(expected);
    }
}
