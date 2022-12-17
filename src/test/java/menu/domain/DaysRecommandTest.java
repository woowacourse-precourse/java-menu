package menu.domain;

import menu.domain.coach.Coach;
import menu.domain.coach.Coachs;
import menu.util.DayStatus;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DaysRecommandTest {
    @Test
    public void initDays_test() {
        DaysRecommand daysRecommand = DaysRecommand.of();

        List<String> days = DayStatus.getDays();
        for (Day day : daysRecommand.getDays()) {
            assertThat(days).contains(day.getDay());
        }
    }

    @Test
    public void initCoach_test() {
        DaysRecommand daysRecommand = DaysRecommand.of();
        List<String> userList = List.of("뽀삐", "가가");
        daysRecommand.initCoachNames(Coachs.of(userList));

        for (Day day : daysRecommand.getDays()) {
            for (Coach coach : day.getCoachMenu().keySet()) {
                assertThat(userList).contains(coach.getName());
            }

        }
    }

}
