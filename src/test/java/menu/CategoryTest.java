package menu;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;


public class CategoryTest {
    private static final Duration RANDOM_TEST_TIMEOUT = Duration.ofSeconds(10L);

    @DisplayName("같은 카테고리가 중복되는 최대 회수가 있다.")
    @Test
    public void categoryGenerateOnDuplicateTest() {
    }
}
