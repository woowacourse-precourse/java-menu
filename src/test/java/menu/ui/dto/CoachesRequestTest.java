package menu.ui.dto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CoachesRequestTest {

    @Test
    public void 코치_이름_입력_테스트() {
        String userInput = "코치1, 코치2, 코치3";
        CoachesRequest coachesRequest = CoachesRequest.from(userInput);

        Assertions.assertThat(coachesRequest.getCoaches()).hasSize(3);
        Assertions.assertThat(coachesRequest.getCoaches()).containsExactly(
                "코치1", "코치2", "코치3"
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"코치1", "코치1, 코치2, 코치3, 코치4, 코치5, 코치6", "코치, 코치"})
    public void 코치_이름_입력_예외_테스트(String input) {
        Assertions.assertThatThrownBy(() -> CoachesRequest.from(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}