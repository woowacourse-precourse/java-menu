package menu.view;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputExceptionTest {
    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    public void null_test(String userInput) {
        assertThatThrownBy(() -> {
            InputException.nullException(userInput);
        }).isInstanceOf(IllegalArgumentException.class);
    }
    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    public void notEndFormat_test(String userInput) {
        assertThatThrownBy(() -> {
            InputException.notEndFormat(userInput);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1,6})
    public void notMemberSize_test(int size) {
        assertThatThrownBy(() -> {
            InputException.notMemberSize(size);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1,5})
    public void notCoachNameSize_test(int size) {
        assertThatThrownBy(() -> {
            InputException.notCoachNameSize(size);
        }).isInstanceOf(IllegalArgumentException.class);
    }


}
