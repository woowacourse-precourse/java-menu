package menu.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WeekTest {
    @Test
    @DisplayName("getWeekFormat 메소드 테스트")
    void 요일_포멧팅_테스트() {
        assertThat(Week.getWeekFormat()).isEqualTo(
                "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]"
        );
    }
}
