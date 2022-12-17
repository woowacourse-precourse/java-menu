package menu.view;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import java.util.List;

class FormatTest {

    @Test
    void toStringTest() {
        List<String> menus = List.of("쌈밥", "미소시루");
        String expected = "[ 쌈밥 | 미소시루 ]";
        assertThat(Format.toString(menus)).isEqualTo(expected);
    }

    @Test
    void toStringDaysTest() {
        List<String> days = List.of("구분", "월요일", "화요일", "수요일", "목요일", "금요일");
        String expected = "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]";
        assertThat(Format.toString(days)).isEqualTo(expected);
    }

}