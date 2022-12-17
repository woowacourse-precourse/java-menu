package menu.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class CategoryEnumTest {

    @DisplayName("각 값마다 올바른 메뉴 이름을 반환하는지 확인한다.")
    @MethodSource("createDate")
    @ParameterizedTest
    void checkTransferCategory(Integer testValue, String expected) {
        // given
        String actual;

        // when
        actual = CategoryEnum.getTransferCategoryName(testValue);

        // then
        assertEquals(actual, expected, "[ERROR] 예상한 카테고리 이름과 다릅니다.");
    }

    static Stream<Arguments> createDate() {
        return Stream.of(
                Arguments.of(1, "일식"),
                Arguments.of(2, "한식"),
                Arguments.of(3, "중식"),
                Arguments.of(4, "아시안"),
                Arguments.of(5, "양식"),
                Arguments.of(10, "")
        );
    }
}
