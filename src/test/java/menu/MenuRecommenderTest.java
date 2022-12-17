package menu;

import menu.domain.Coach;
import menu.domain.MenuRecommender;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import repository.MenuForWeekRepository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class MenuRecommenderTest {
    @Test
    public void testMenuRecommender() {
        List<Coach> coaches = List.of(new Coach("승원"), new Coach("자인"));
        MenuForWeekRepository.initializeCoaches(coaches);
        MenuRecommender.addRecommendMenus(coaches);
    }

    @Test
    public void testMenuRecommender_() {
        List<Coach> coaches = List.of(new Coach("승원"), new Coach("자인"));
        MenuForWeekRepository.initializeCoaches(coaches);
        MenuRecommender.addRecommendMenus(coaches);
    }

    // 테스트 사용 예시
//    @ParameterizedTest
//    @ValueSource(ints = {1, 10, 20})
//    void 사용자_재시도_테스트(int trials) {
//
//    }
//
//
//    @ParameterizedTest
//    @MethodSource("generateMovableBridge")
//    @DisplayName("게임에서 이겼는지 확인 (=사용자가 마지막 위치에 있는지 확인)")
//    void 마지막_위치_확인_테스트(List<String> movableSide) {
//    }
//
//    static Stream<Arguments> generateMovableBridge() {
//        return Stream.of(
//                Arguments.of(Arrays.asList("U", "U", "U")),
//                Arguments.of(Arrays.asList("U", "U", "U", "U")),
//                Arguments.of(Arrays.asList("U", "U", "U", "U", "U")),
//                Arguments.of(Arrays.asList(
//                        "U", "U", "U", "U", "U", "U", "U", "U", "U", "U",
//                        "U", "U", "U", "U", "U", "U", "U", "U", "U", "U"
//                ))
//        );
//    }
}