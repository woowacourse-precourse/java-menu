package menu.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;

@DisplayName("Coach 클래스")
@DisplayNameGeneration(ReplaceUnderscores.class)
class CoachTest {

    private Coach coach;

    @BeforeEach
    void setCoach() {
        coach = new Coach(new CoachName("안녕"), List.of("쌈밥", "분짜"));
    }

    @Test
    void coach_클래스는_생성시_null_이_들어오면_IEA_예외를_발생시킨다() {
        assertThatThrownBy(() -> new Coach(null, List.of("안녕")))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Coach(new CoachName("안녕"), null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void canEat_메서드는_이미_먹은_음식일_경우_false_를_return_한다() {
        assertTrue(coach.canEat("김치찌개"));

        coach.eat("김치찌개");
        assertFalse(coach.canEat("김치찌개"));
    }

    @Test
    void eat_메서드는_먹을_수_없거나_이미_먹었을_경우_IEA_예외를_발생시킨다() {
        assertThatThrownBy(() -> coach.eat("쌈밥"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void eat_메서드는_먹을_수_있는_경우_먹고_기록해둔다() {
        coach.eat("김치찌개");
        assertThat(coach.toDto()).contains("김치찌개");
    }
}
