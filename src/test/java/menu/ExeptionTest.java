package menu;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static menu.exception.ExceptionMassage.COACH_CNT_ERROR;
import static menu.exception.ExceptionMassage.COACH_NAME_LENGTH_ERROR;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

public class ExeptionTest extends NsTest {
    @Test
    void  oneValueInputTest() {
            assertSimpleTest(() -> {
                runException("구구");
                assertThat(output()).contains(COACH_CNT_ERROR.getError());
            });
        }
    @Test
    void  sixValueInputTest() {
        assertSimpleTest(() -> {
            runException("구구,철수,나미,누구,나와,너와");
            assertThat(output()).contains(COACH_CNT_ERROR.getError());
        });
    }
    @Test
    void  shortNameInputTest() {
        assertSimpleTest(() -> {
            runException("구,구구");
            assertThat(output()).contains(COACH_NAME_LENGTH_ERROR.getError());
        });
    }
    @Test
    void longNameInputTest() {
        assertSimpleTest(() -> {
            runException("구구구구구,구구");
            assertThat(output()).contains(COACH_NAME_LENGTH_ERROR.getError());
        });
    }
    @Test
    void sameNameInputTest() {
        assertSimpleTest(() -> {
            runException("구구,구구");
            assertThat(output()).contains(COACH_NAME_LENGTH_ERROR.getError());
        });
    }
    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
