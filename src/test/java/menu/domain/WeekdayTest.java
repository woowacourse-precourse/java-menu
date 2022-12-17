package menu.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class WeekdayTest {

    @Test
    void getOrderedWeekdays() {

        assertThat(Weekday.getOrderedWeekdays())
                .isEqualTo(List.of(Weekday.MONDAY, Weekday.TUESDAY, Weekday.WEDNESDAY, Weekday.THURSDAY, Weekday.FRIDAY));
    }
}