package menu.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidatorTest {
    @Test
    @DisplayName("코치의 이름의 길이를 확인하는 함수 테스트")
    void checkCoachesNameTest() {
        List<String> coaches_1 = List.of("tom","b");
        assertThatThrownBy(() -> Validator.validateCoachName(coaches_1)).isInstanceOf(IllegalArgumentException.class);

        List<String> coaches_2 = List.of("tom","bellee");
        assertThatThrownBy(() -> Validator.validateCoachName(coaches_2)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("코치 리스트의 길이를 확인하는 함수 테스트")
    void checkCoachesListLengthTest() {
        List<String> coaches_1 = List.of();
        assertThatThrownBy(() -> Validator.validateCoachesLength(coaches_1)).isInstanceOf(IllegalArgumentException.class);

        List<String> coaches_2 = List.of("woo","wa","tech","cou","se","test");
        assertThatThrownBy(() -> Validator.validateCoachesLength(coaches_2)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("먹지 못하는 메뉴의 갯수를 확인하는 함수 테스트")
    void checkInEdibleMenuLengthTest() {
        List<String> inEdibleMenu = List.of("쌈밥","된장찌개","비빔밥");
        assertThatThrownBy(() -> Validator.validateInEdibleMenuLength(inEdibleMenu)).isInstanceOf(IllegalArgumentException.class);
    }
}
