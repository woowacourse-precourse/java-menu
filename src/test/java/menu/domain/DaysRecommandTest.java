package menu.domain;

import menu.domain.coach.Coach;
import menu.domain.coach.Coachs;
import menu.util.DayStatus;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class DaysRecommandTest {
    @Test
    public void initDays_test() {
        DaysRecommand daysRecommand = DaysRecommand.of();
        Map<String, Day> days = daysRecommand.getDays();
        for (DayStatus dayStatus : DayStatus.values()) {
            assertThat(days.keySet()).contains(days.get(dayStatus.getDay()).getDay());
        }
    }

    @Test
    public void initCoach_test() {
        DaysRecommand daysRecommand = DaysRecommand.of();
        List<String> userList = List.of("뽀삐", "가가");
        daysRecommand.initCoachNames(Coachs.of(userList));


        Map<String, Day> days = daysRecommand.getDays();

        for (DayStatus dayStatus : DayStatus.values()) {
            Day day = days.get(dayStatus.getDay());
            for (Coach coach :  days.get(dayStatus.getDay()).getCoachMenu().keySet()) {
                assertThat(userList).contains(coach.getName());
            }
        }
    }

}
