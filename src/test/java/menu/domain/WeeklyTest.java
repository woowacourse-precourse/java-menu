package menu.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WeeklyTest {

    @DisplayName("출력 요일 수를 확인한다.")
    @Test
    void checkDayCount() {
        assertThat(Weekly.getAllDaySize()).isEqualTo(5);
    }

    @DisplayName("출력 요일을 확인한다.")
    @Test
    void checkDays() {
        assertThat(Weekly.getAllDays()).isEqualTo(List.of("월요일","화요일","수요일","목요일","금요일"));
    }
}
