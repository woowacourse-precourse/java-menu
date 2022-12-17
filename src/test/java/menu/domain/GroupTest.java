package menu.domain;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class GroupTest {
    @ParameterizedTest
    @MethodSource("coachProvider")
    void 코치의_수가_범위를_벗어나면_예외를_발생시키는지_테스트(List<Coach> coaches) {
        assertThatThrownBy(() -> new Group(coaches))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private Stream<Arguments> coachProvider() {
        return Stream.of(
                Arguments.of(
                        List.of()),
                Arguments.of(
                        List.of(new Coach(new CoachName("우성1")))),
                Arguments.of(
                        List.of(new Coach(new CoachName("우성1")), new Coach(new CoachName("우성2")),
                                new Coach(new CoachName("우성3")), new Coach(new CoachName("우성4")),
                                new Coach(new CoachName("우성5")),  new Coach(new CoachName("우성6"))))
        );
    }

    @ParameterizedTest
    @MethodSource("indistinctCoachProvider")
    void 코치가_같은_이름을_가질_경우_예외를_발생시키는지_테스트(List<Coach> coaches) {
        assertThatThrownBy(() -> new Group(coaches))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private Stream<Arguments> indistinctCoachProvider() {
        return Stream.of(
                Arguments.of(
                        List.of(new Coach(new CoachName("우성1")), new Coach(new CoachName("우성1"))))
        );
    }
}