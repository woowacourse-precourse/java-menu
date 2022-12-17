package menu;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import menu.Model.Coach;
import menu.Model.Coachs;

public class CoachsTest {
    @DisplayName("코치 리스트 예외 테스트 - 2명 이하일 경우")
    @ValueSource(strings = { "조은찬" })
    @ParameterizedTest
    public void coachsExceptionTest1(String input) {
        assertThatThrownBy(() -> new Coachs(input))
                .isInstanceOf(IllegalStateException.class);
    }

    @DisplayName("코치 리스트 예외 테스트 - 5명 이상일 경우")
    @ValueSource(strings = { "조은찬,구구,제임스,김코치,김왼손,포비" })
    @ParameterizedTest
    public void coachsExceptionTest2(String input) {
        assertThatThrownBy(() -> new Coachs(input))
                .isInstanceOf(IllegalStateException.class);
    }

    @DisplayName("코치 리스트 생성 테스트 ")
    @ValueSource(strings = { "조은찬,구구,제임스,김코치,김왼손" })
    @ParameterizedTest
    public void coachsGenerationTeset(String input) {
        Coachs coachs = new Coachs(input);
        int i = 0;
        for (Coach coach : coachs.getCoachs()) {
            assertThat(coach.getName()).isEqualTo(List.of("조은찬", "구구", "제임스", "김코치", "김왼손").get(i));
            i++;
        }
    }
}
