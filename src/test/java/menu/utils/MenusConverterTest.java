package menu.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MenusConverterTest {

    @DisplayName("메뉴가 2개보다 많은 경우 예외가 발생한다.")
    @ValueSource(strings = {"김밥,라면,오징어", "김밥,라면,오징어,삼겹살"})
    @ParameterizedTest
    void convertFailBySize(String input) {
        assertThatThrownBy(() -> MenusConverter.convert(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("못 먹는 메뉴 목록을 정상적으로 변환한다.")
    @ValueSource(strings = {" ", "콩", "배,감"})
    @ParameterizedTest
    void convert(String input) {
        List<String> menus = MenusConverter.convert(input);

        List<String> result = Arrays.stream(input.split(","))
                .map(s -> s.trim())
                .filter(s -> s.length() != 0)
                .collect(Collectors.toList());

        assertThat(menus.size()).isEqualTo(result.size());
    }
}