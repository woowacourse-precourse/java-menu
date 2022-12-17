package menu.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MenuRecommenderTest {

    @DisplayName("코치는 2~5명 사이가 아니면 예외를 발생한다.")
    @ParameterizedTest
    @MethodSource("generateCoach")
    void sizeTest(List<Coach> coaches) {
        assertThatThrownBy(() -> new MenuRecommender(coaches))
                .isInstanceOf(IllegalArgumentException.class);
    }


    static Stream<Arguments> generateCoach() {
        return Stream.of(
                Arguments.of(generateCoachesBySize(1)),
                Arguments.of(generateCoachesBySize(6))
        );
    }
    
    private static List<Coach> generateCoachesBySize(int size) {
        List<Coach> coaches = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            coaches.add(new Coach("포비"));
        }
        return coaches;
    }
}