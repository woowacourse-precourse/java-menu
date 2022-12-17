package menu;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ValidateTest {
    private static InputView inputView = new InputView();

    @DisplayName("코치 이름 입력 유효성 검증 테스트")
    @Test
    void 코치_인원수_검증_테스트() {
        InputStream in = generateUserInput("");
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);

        assertThat(inputView.readCoachNames());
    }

    public static InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
}
