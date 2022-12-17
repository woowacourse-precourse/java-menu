package menu.Controller;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RunTest extends NsTest {
    @Test
    void 코치_이름_예외_테스트() {
        assertSimpleTest(() -> {
            runException("토미");
            assertThat(output()).contains("[ERROR]");
        });
    }

    @Test
    void 코치_이름_예외_테스트2() {
        assertSimpleTest(() -> {
            runException("토미,제에이임스으");
            assertThat(output()).contains("[ERROR]");
        });
    }

    @Override
    protected void runMain() {
        new Run();
    }
}