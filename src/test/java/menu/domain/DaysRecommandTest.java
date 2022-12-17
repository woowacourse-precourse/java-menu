package menu.domain;

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
}
