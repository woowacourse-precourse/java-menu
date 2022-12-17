package menu;

import menu.input.InputValidation;
import menu.input.InputView;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputValidationTest {

    @DisplayName("코치 이름 입력 실패 테스트")
    @ValueSource(strings = {"동혁,주혁,환용,규완,지윤,성호", "동혁", "", "안녕하세요,반갑습니", "안,반,갑"})
    @ParameterizedTest
    void 코치_이름_입력_실패_테스트(String coaches) {
        Assertions.assertThatThrownBy(() -> InputValidation.validateReadCoaches(coaches))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("코치 이름 입력 성공 테스트")
    @Test
    void 코치_이름_입력_성공_테스트() {
        String coaches = "동혁,주혁,환용,박지윤,김성호";
        org.junit.jupiter.api.Assertions.assertDoesNotThrow(() -> InputValidation.validateReadCoaches(coaches));
    }

    @DisplayName("안 먹는 음식 입력 실패 테스트")
    @ValueSource(strings = {"김밥,떡볶이,김치찌개", "김밥,떡볶이,김치찌개,된장찌개"})
    @ParameterizedTest
    void 안먹는_음식_입력_실패_테스트(String menus) {
        Assertions.assertThatThrownBy(() -> InputValidation.validateReadNotEatMenus(menus))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("안 먹는 음식 입력 성공 테스트")
    @ValueSource(strings = {"김밥,떡볶이", "라자냐,파스타", ""})
    @ParameterizedTest
    void 안먹는_음식_입력_성공_테스트(String menus) {
        org.junit.jupiter.api.Assertions.assertDoesNotThrow(() -> InputValidation.validateReadNotEatMenus(menus));
    }
}
