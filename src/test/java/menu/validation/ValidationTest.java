package menu.validation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class ValidationTest {

    private static final String ERROR_MESSAGE = "[ERROR]";


    @DisplayName("코치의 수가 2이상 4이하가 아닌 경우에 오류가 발생한다.")
    @ParameterizedTest
    @MethodSource ("generateData")
    void checkCoachLength2To4(List<String> input) {
        Assertions.assertThatThrownBy(() -> Validation.validateCoachNameLength(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("같이 밥먹는 코치의 수가 2이상 5이하가 아닌 경우에 오류가 발생한다.")
    @ParameterizedTest
    @MethodSource ("generateData2")
    void checkCoachSize2To5(List<String> input) {
        Assertions.assertThatThrownBy(() -> Validation.validateCoachsLength(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ERROR_MESSAGE);
    }

    static Stream<Arguments> generateData(){
        return Stream.of(
        Arguments.of(Arrays.asList("", "석환입니다", "석"))
        );
    }
    static Stream<Arguments> generateData2(){
        return Stream.of(
            Arguments.of(Arrays.asList("민주", "석환", "재준","석주", "건회", "재혁")),
            Arguments.of(Arrays.asList("건회"))
        );
    }
}