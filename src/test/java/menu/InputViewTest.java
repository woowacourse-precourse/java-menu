package menu;

import menu.view.InputView;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class InputViewTest {

    static InputView inputView;

    @BeforeAll
    static void setup() {
        inputView = new InputView();
    }

    @Test
    void coachNameOverSizeTest() {
        Assertions.assertThatThrownBy(() -> {
            inputView.validateCoachName("너무길어요");
        }).isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void coachNameUnderSizeTest() {
        Assertions.assertThatThrownBy(() -> {
            inputView.validateCoachName("짧");
        }).isExactlyInstanceOf(IllegalArgumentException.class);
    }
}
