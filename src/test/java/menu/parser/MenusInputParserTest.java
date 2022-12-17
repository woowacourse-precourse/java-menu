package menu.parser;

import menu.exception.TooManyMenusException;
import menu.utils.MenusInputParser;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MenusInputParserTest {
    @DisplayName("음식 이름 반환 기능 테스트")
    @Test
    void parseMenus() {
        List<String> result = MenusInputParser.parser("사과,과자");
        List<String> expected = List.of("사과", "과자");

        Assertions.assertThat(result).isEqualTo(expected);
    }

    @DisplayName("음식 개수 예외 테스트")
    @Test
    void invalidMenuCount() {
        Assertions.assertThatThrownBy(() -> MenusInputParser.parser("사과,과자,자전거"))
                .isInstanceOf(TooManyMenusException.class);
    }
}
