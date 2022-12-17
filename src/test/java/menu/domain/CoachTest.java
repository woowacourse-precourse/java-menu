package menu.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CoachTest {
    @ParameterizedTest
    @MethodSource("makeMenusOutOfSize")
    void 못먹는_음식이_2개_이상이면_예외를_발생시키는지_테스트(List<String> inedible) {
        Coach dummyCoach = new Coach(new CoachName("우성"));

        assertThatThrownBy(() -> dummyCoach.addInedibleMenus(inedible))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private Stream<Arguments> makeMenusOutOfSize() {
        return Stream.of(
                Arguments.of(List.of("음식1", "음식2", "음식3")),
                Arguments.of(List.of("음식1", "음식2", "음식3", "음식4"))
        );
    }

    @ParameterizedTest
    @MethodSource("makeMenusIndistinct")
    void 메뉴_목록이_중복되는_경우_예외를_발생시키는지_테스트(List<String> inedible) {
        Coach dummyCoach = new Coach(new CoachName("우성"));

        assertThatThrownBy(() -> dummyCoach.addInedibleMenus(inedible))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private Stream<Arguments> makeMenusIndistinct() {
        return Stream.of(
                Arguments.of(List.of("음식1", "음식1"))
        );
    }
}