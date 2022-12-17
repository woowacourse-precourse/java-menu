package menu;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidInputCheckerTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("코치 수 초과")
    @ValueSource(strings = {"토미,제임스,포코,이상윤,상윤이,윤상이", "토미"})
    @ParameterizedTest
    void isNotValidCoachesLen(String input){
        assertThatThrownBy(() -> ValidInputChecker.validateCoachesAndToList(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("못 먹는 음식 에러")
    @ValueSource(strings = {"동우,시스", "우동,스시,토마토 달걀볶음"})
    @ParameterizedTest
    void isNotValidInedibleFoodsLen(String input){
        assertThatThrownBy(() -> ValidInputChecker.validateInedibleFoodsAndToList(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("못 먹는 음식 유효")
    @Test
    void isValidInedibleFoods(){
        assertThat(ValidInputChecker.validateInedibleFoodsAndToList("")).isEqualTo(null);
    }
}
