package menu.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTest {

//    @DisplayName("코치 이름 입력값에 대한 예외 처리")
//    @ValueSource(strings = {"구,제", "구구,제임스,", ",구구,제임스", "구구구구구,제임스", "구구", "제임스1,제임스2,제임스3,제임스4,제임스5"})
//    @ParameterizedTest
//    void validateCouchNameInput(String input) {
//
//        assertThatThrownBy(() -> {
//            InputView.validateNames(input);
//        }).isInstanceOf(IllegalArgumentException.class);
//    }

//    @DisplayName("못먹는 음식 입력값에 대한 예외 처리 테스트")
//    @ValueSource(strings = {"떡볶이,", "떡볶이,순대,오징어"})
//    @ParameterizedTest
//    void validateUneatableDishInput(String input) {
//        assertThatThrownBy(() -> {
//            InputView.validateMenus(input);
//        }).isInstanceOf(IllegalArgumentException.class);
//    }
}