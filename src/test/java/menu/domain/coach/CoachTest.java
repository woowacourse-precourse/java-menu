package menu.domain.coach;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CoachTest {

    @ParameterizedTest
    @ValueSource(strings = {"a", "코치코치코"})
    public void 코치_이름은_2글자에서_4글자_사이만_가능하다(String input) {
        Assertions.assertThatThrownBy(() -> Coach.fromName(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}