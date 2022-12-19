package menu.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@DisplayName("코치들 정보(이름, 못 먹는 음식) 테스트")
class CoachInfoTest {
    CoachInfo coachInfo = new CoachInfo(List.of("토미", "제임스", "포코"));
    @ParameterizedTest
    @MethodSource("generateWrongNameLengthData")
    void 코치_이름_길이_유효성_테스트(List<String> names) {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new CoachInfo(names));
    }

    static Stream<Arguments> generateWrongNameLengthData() {
        return Stream.of(
                Arguments.of(Arrays.asList("ab", "ba", "c")),
                Arguments.of(Arrays.asList("xa", "ya", "zqwer"))
        );
    }

    @ParameterizedTest
    @MethodSource("generateWrongCoachNumberData")
    void 코치_인원_유효성_테스트(List<String> coachInfo) {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new CoachInfo(coachInfo));
    }

    static Stream<Arguments> generateWrongCoachNumberData() {
        return Stream.of(
                Arguments.of(Arrays.asList("ab", "ba", "cr","ewr","qet","qert")),
                Arguments.of(List.of("xa"))
        );
    }

    @Test
    void 코치들의_이름은_중복_안된다() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new CoachInfo(List.of("토미", "토미", "포코")));
    }

    @Test
    void 못_먹는_음식은_최대_2개() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> coachInfo.initForbiddenFood("토미", List.of("우동", "스시", "규동")));
    }

    @Test
    void 못_먹는_음식_간_중복_금지() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> coachInfo.initForbiddenFood("토미", List.of("우동", "우동")));
    }

    @ParameterizedTest
    @CsvSource(value = {"토미,우동,true","포코,스시,false","제임스,우동,false"})
    void 코치_못_먹는_음식인지_판단_테스트(String name, String menu, boolean result) {
        coachInfo.initForbiddenFood("토미", List.of("우동", "스시"));
        coachInfo.initForbiddenFood("제임스", List.of("뇨끼", "월남쌈"));
        coachInfo.initForbiddenFood("포코", List.of());

        org.assertj.core.api.Assertions.assertThat(coachInfo.isForbiddenMenu(name, menu))
                .isEqualTo(result);
    }
}