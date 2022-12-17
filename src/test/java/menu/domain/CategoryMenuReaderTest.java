package menu.domain;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class CategoryMenuReaderTest {
    private final CategoryMenuReader categoryMenuReader = CategoryMenuReader.getInstance();

    @Test
    void 테스트_파일에서_카테고리_메뉴_리스트_반환() throws IOException {
        String filePath = "src/test/java/src/test.md";
        Map<Category, List<String>> expected = Map.of(
                Category.JAPAN, List.of("규동", "우동"),
                Category.KOREA, List.of("김밥", "김치찌개"),
                Category.CHINA, List.of("깐풍기"),
                Category.ASIAN, List.of("팟타이"),
                Category.WESTERN, List.of("라자냐")
        );

        Map<Category, List<String>> actual = categoryMenuReader.readCategoryMenus(filePath);

        assertThat(actual).isEqualTo(expected);

    }
}
