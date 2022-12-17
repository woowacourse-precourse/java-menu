package menu.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import menu.domain.Coach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CoachesConverterTest {

    @DisplayName("코치가 2명보다 작은 경우 예외가 발생한다.")
    @ValueSource(strings = {"   ,안녕", "안녕", "안녕,  ,  "})
    @ParameterizedTest
    void convertFailBySize(String input) {
        assertThatThrownBy(() -> CoachesConverter.convert(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("코치가 5명보다 많은 경우 예외가 발생한다.")
    @ValueSource(strings = {"한국,미국,중국,일본,러시아,캐나다,브라질", "한국,미국,일본,중국,러시아,캐나다"})
    @ParameterizedTest
    void convertFailBySizeOver(String input) {
        assertThatThrownBy(() -> CoachesConverter.convert(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("코치가 중복되는 경우 예외가 발생한다.")
    @ValueSource(strings = {"안녕,안녕", "안녕,안녕,안녕", "안녕,안녕,안녕,안녕"})
    @ParameterizedTest
    void convertFailByDuplication(String input) {
        assertThatThrownBy(() -> CoachesConverter.convert(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("코치 목록으로 정상적으로 변환한다.")
    @ValueSource(strings = {"안녕,하이", "안녕,하이,헬로", "안녕,하이,헬로,니하오", "안녕,하이,헬로,니하오,굿바이"})
    @ParameterizedTest
    void convert(String input) {
        List<Coach> coaches = CoachesConverter.convert(input);

        assertThat(coaches.size()).isEqualTo(input.split(",").length);
    }
}