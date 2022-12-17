package menu.domain.enums;

import java.util.List;
import java.util.stream.Stream;
import menu.message.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MenuTest {
    private static Stream<Arguments> generateRandomMenuNames() {
        return Stream.of(
                Arguments.of(List.of("분짜", "김치찌개", "규동", "파인애플 볶음밥", "라자냐"))
        );
    }

    private static Stream<Arguments> generateNotExistRandomMenuNames() {
        return Stream.of(
                Arguments.of(List.of("분", "김치찌", "규", "파인플 볶음밥", "자냐"))
        );
    }

    @DisplayName("존재하는 메뉴 검사 테스트")
    @ParameterizedTest
    @MethodSource("generateRandomMenuNames")
    void isExists_success(final List<String> menuNames) {
        // then
        Assertions.assertThat(Menu.isExists(menuNames)).isTrue();
    }

    @DisplayName("존재하지 않는 메뉴 검사 테스트")
    @ParameterizedTest
    @MethodSource("generateNotExistRandomMenuNames")
    void isExists_fail(final List<String> menuNames) {
        // then
        Assertions.assertThat(Menu.isExists(menuNames)).isFalse();
    }

    @DisplayName("존재하지 않는 메뉴 변환시 예외 발생 테스트")
    @Test
    void convert() {
        // then
        Assertions.assertThatThrownBy(() -> Menu.convert(List.of("dd", "aa")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_MENU);
    }
}