package menu.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class MenuRecommendationTest {
    private MenuRecommendation menuRecommendation;

    @BeforeEach
    void setUp() {
        this.menuRecommendation = new MenuRecommendation();
    }

    @ParameterizedTest
    @DisplayName("코치 수가 2와 5 사이가 아니거나, 이름 길이가 2와 4 사이가 아니라면 예외가 발생한다")
    @MethodSource("provideListsForWrongCoachCount")
    void wrongCoachCount(List<String> coaches) {
        assertThatThrownBy(() -> menuRecommendation.initializeCoaches(coaches))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");
    }

    private static Stream<List<String>> provideListsForWrongCoachCount() {
        return Stream.of(
                List.of("가나"),
                List.of("가나","다라","마바","사아","자차","카타"),
                List.of("가","나다라아마"),
                List.of("가","나다")
        );
    }

    @ParameterizedTest
    @DisplayName("못 먹는 음식 개수가 0과 2사이가 아니거나, 포함된 음식이 아니라면 예외가 발생한다")
    @MethodSource("provideListsForWrongDislikeFood")
    void wrongDislikeFood(List<String> foods) {
        menuRecommendation.initializeCoaches(List.of("가나","다라"));

        assertThatThrownBy(() -> menuRecommendation.initializeDislikeFoods("가나", foods))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");
    }

    private static Stream<List<String>> provideListsForWrongDislikeFood() {
        return Stream.of(
                List.of("팟타이","똠얌꿍","피자"),
                List.of("팟타이","오징어")
        );
    }
}