package menu;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.mockStatic;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.MockedStatic;

public class ErrorTest extends IOTest{
    private static final Duration RANDOM_TEST_TIMEOUT = Duration.ofSeconds(10L);

    @Test
    void 코치_2명이하_입력_테스트() {
        systemIn("3");
        ApplicationTest applicationTest = new ApplicationTest();
//        assertThatThrownBy(applicationTest.runMain()).isInstanceOf(i)
    }

}
