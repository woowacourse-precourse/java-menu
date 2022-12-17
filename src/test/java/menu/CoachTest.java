package menu;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import menu.domain.Coach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CoachTest {

    @ParameterizedTest
    @ValueSource(strings = {"나", "나는제이슨"})
    void 이름이_2자_미만이거나_5자_이상이면_예외를_발생시킨다(String name) {
        final List<String> bannedFoods = List.of("우동", "규동");
        assertThatThrownBy(() -> new Coach(name, bannedFoods))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("코치의 이름은 2 ~ 4자 사이여야 합니다.");
    }

    @Test
    void 못_먹는_음식이_3개_이상이면_예외를_발생시킨다() {
        assertThatThrownBy(() -> new Coach("제이슨", List.of("우동", "규동", "짬뽕")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("못 먹는 음식은 최대 2개까지만 입력할 수 있습니다.");
    }
}