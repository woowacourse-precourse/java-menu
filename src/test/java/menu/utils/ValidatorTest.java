package menu.utils;

import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class ValidatorTest {

    @Test
    @DisplayName("코치 이름 중복 테스트")
    void 예외_테스트() {
        String[] names = new String[2];
        Arrays.fill(names, "태윤");

        assertThatThrownBy(() -> Validator.checkCoachesCount(names))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    @DisplayName("코치 이름 범위 초과 태스트")
    void 예외_테스트2() {
        String[] names = {"태윤", "포비", "우아한", "테크", "코스", "짱짱"};
        Arrays.fill(names, "태윤");

        assertThatThrownBy(() -> Validator.checkCoachesCount(names))
                .isInstanceOf(IllegalArgumentException.class);
    }


}
