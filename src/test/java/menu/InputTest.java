package menu;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import menu.domain.exception.InputException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputTest extends NsTest {
    @DisplayName("코치 이름 개수가 2보다 작은 입력 테스트")
    @ValueSource(strings = {"톰톰", "하"})
    @ParameterizedTest
    void getLessCoachName(String input) {
        assertSimpleTest(() -> {
            runException(input);
            assertThat(output()).contains(InputException.OUT_OF_COACH_NAME_COUNT_MINIMUM.getExceptionMessage());
        });
    }

    @DisplayName("코치 이름 개수가 5보다 많은 입력 테스트")
    @ValueSource(strings = {"톰톰,하하,하하하,호호,히히,후후", "하하하,오오오,우우우,오와,우우,후후"})
    @ParameterizedTest
    void getMoreCoachName(String input) {
        assertSimpleTest(() -> {
            runException(input);
            assertThat(output()).contains(InputException.OUT_OF_COACH_NAME_COUNT_MAXIMUM.getExceptionMessage());
        });
    }

    @DisplayName("코치 이름 길이가 2글자 보다 작은 경우")
    @ValueSource(strings = {"톰,하하하", "호후, "})
    @ParameterizedTest
    void getLessCoachNameLength(String input) {
        assertSimpleTest(() -> {
            runException(input);
            assertThat(output()).contains(InputException.OUT_OF_COACH_NAME_LENGTH_MINIMUM.getExceptionMessage());
        });
    }

    @DisplayName("코치 이름 길이가 4글자 보다 큰 경우")
    @ValueSource(strings = {"톰톰톰톰톰톰톰톰,하하하", "김김김,이이이이이"})
    @ParameterizedTest
    void getMoreCoachNameLength(String input) {
        assertSimpleTest(() -> {
            runException(input);
            assertThat(output()).contains(InputException.OUT_OF_COACH_NAME_LENGTH_MAXIMUM.getExceptionMessage());
        });
    }

    @DisplayName("못 먹는 메뉴가 없는 메뉴일 때")
    @ValueSource(strings = {"초코파이", "빵"})
    @ParameterizedTest
    void getInvalidFoodName(String input) {
        assertSimpleTest(() -> {
            runException("톰톰,뱅뱅", input);
            assertThat(output()).contains(InputException.INVALID_MENU.getExceptionMessage());
        });
    }

    @DisplayName("못 먹는 메뉴 개수가 3개 이상일 때")
    @ValueSource(strings = {"김치찌개,쌈밥,우동", "김치찌개,쌈밥,우동,제육볶음"})
    @ParameterizedTest
    void getMoreFoodName(String input) {
        assertSimpleTest(() -> {
            runException("톰톰,뱅뱅", input);
            assertThat(output()).contains(InputException.OUT_OF_RANGE_MENU_COUNT.getExceptionMessage());
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
