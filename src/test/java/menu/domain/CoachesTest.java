package menu.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class CoachesTest {
    private final Coaches coaches = new Coaches();

    @Test
    void 예외_짧은_코치_이름() {
        List<String> coachNames = List.of("일", "이삼");
        assertThatThrownBy(() -> coaches.addCoaches(coachNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 예외_긴_코치_이름() {
        List<String> coachNames = List.of("일이", "삼사오육칠팔");
        assertThatThrownBy(() -> coaches.addCoaches(coachNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 코치_이름_목록_반환() {
        coaches.addCoaches(List.of("우진", "포비", "왼손"));
        List<String> coachNames = coaches.getCoachNames();
        assertThat(coachNames).hasSize(3);
        assertThat(coachNames.get(0)).isEqualTo("우진");
    }
}