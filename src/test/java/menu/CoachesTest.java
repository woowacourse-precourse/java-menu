package menu;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import menu.domain.Coach;
import menu.domain.Coaches;
import org.junit.jupiter.api.Test;

class CoachesTest {

    private static final List<String> BANNED_FOODS = List.of("우동", "규동");

    private Coach generateCoach(String name) {
        return new Coach(name, BANNED_FOODS);
    }

    @Test
    void 코치가_2명_미만이면_예외를_발생시킨다() {
        assertThatThrownBy(() -> new Coaches(List.of(generateCoach("제이슨"))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("코치는 최소 2명에서 최대 5명까지 입력해야 합니다.");
    }

    @Test
    void 코치가_5명_초과이면_예외를_발생시킨다() {
        assertThatThrownBy(() -> new Coaches(List.of(
                generateCoach("제이슨"), generateCoach("포비"), generateCoach("엠제이"),
                generateCoach("왓슨"), generateCoach("캐딜락"), generateCoach("제리")
        )))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("코치는 최소 2명에서 최대 5명까지 입력해야 합니다.");
    }
}