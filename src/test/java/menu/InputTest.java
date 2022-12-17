package menu;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import menu.view.InputView;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class InputTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("코치의 이름은 최소 2글자, 최대 4글자가 아닌 경우 예외 처리")
    @CsvSource({"옹", "규규규규규", "야"})
    @ParameterizedTest
    void invalidLength(String string) {
        InputStream in = generateUserInput(string);
        System.setIn(in);

        assertThatThrownBy(() -> InputView.readCoachName())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("코치는 최소 2명, 최대 5명이 아닌 경우 예외 처리")
    @CsvSource({"옹웅웅", "규규", "야야야야", "야허", "규리", "많다"})
    @ParameterizedTest
    void invalidSize(String string) {
        InputStream in = generateUserInput(string);
        System.setIn(in);

        assertThatThrownBy(() -> InputView.readCoachName())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    public static InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
}
