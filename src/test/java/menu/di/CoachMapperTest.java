package menu.di;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import menu.domain.Coach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;

@DisplayName("CoachMapper 클래스")
@DisplayNameGeneration(ReplaceUnderscores.class)
class CoachMapperTest {

    @Test
    void toCoach_메서드는_주어진_값을_바탕으로_coach_리스트를_반환한다() {
        List<Coach> coaches = new CoachMapper(List.of("테스트"), List.of(List.of("안 먹음"))).toCoaches();
        Coach coach = coaches.get(0);
        assertTrue(coach.canEat("없는 메뉴"));
        assertFalse(coach.canEat("안 먹음"));
        assertThat(coach.toDto()).containsExactly("테스트");
    }
}
