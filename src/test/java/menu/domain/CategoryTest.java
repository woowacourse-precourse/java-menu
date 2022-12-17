package menu.domain;

import java.util.List;
import java.util.stream.Collectors;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CategoryTest {
    @Test
    void from_메소드는_코드를_입력하면_Category를_반환() {
        List<Integer> codes = List.of(1, 2, 3, 4, 5);
        List<Category> expectedResult = List.of(Category.JAPANESE, Category.KOREA, Category.CHINESE, Category.ASIAN,
                Category.WEST);
        List<Category> methodResult = codes.stream()
                .map(Category::from)
                .collect(Collectors.toList());

        Assertions.assertThat(methodResult).containsAll(expectedResult);
    }

    @Test
    void plusCount_메소드는_호출하면_Category의_count가_1증가한다() {
        Category.ASIAN.plusCount();
        Category.ASIAN.plusCount();

        Assertions.assertThat(Category.ASIAN.getCount())
                .isEqualTo(2);
    }
}