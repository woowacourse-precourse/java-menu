package menu.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static menu.model.MenuCategory.ASIAN;
import static menu.model.MenuCategory.CHINA;
import static menu.model.MenuCategory.JAPAN;
import static menu.model.MenuCategory.KOREA;
import static menu.model.MenuCategory.WESTERN;
import static menu.model.MenuCategory.pickCategory;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("MenuCategory 관련 테스트를 진행한다.")
class MenuCategoryTest {

    @ParameterizedTest
    @MethodSource("pickCategoryData")
    void 숫자로_카테고리가_나오는지_확인한다(final int number, final MenuCategory category) {
        assertThat(pickCategory(number)).isEqualTo(category);
    }

    private static Stream<Arguments> pickCategoryData() {
        return Stream.of(
                Arguments.of(1, JAPAN),
                Arguments.of(2, KOREA),
                Arguments.of(3, CHINA),
                Arguments.of(4, ASIAN),
                Arguments.of(5, WESTERN)
        );
    }
}