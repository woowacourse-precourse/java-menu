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

    @DisplayName("코치 이름 개수가 올바르지 않은 입력 테스트")
    @ValueSource(strings = {"톰톰,하하,하하하,호호,히히,후후", "하하하,오오오,우우우,오와,우우,후후"})
    @ParameterizedTest
    void getMoreCoachName(String input) {
        assertSimpleTest(() -> {
            runException(input);
            assertThat(output()).contains(InputException.OUT_OF_COACH_NAME_COUNT_MAXIMUM.getExceptionMessage());
        });
    }


    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
