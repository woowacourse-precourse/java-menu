package menu.view;

import java.util.Objects;

public abstract class DefaultInputView {

    private static final String INPUT_EXCEPTION_MESSAGE = "입력은 공백일 수 없습니다.";

    protected void validateInput(String input) {
        if (Objects.isNull(input) || input.isBlank()) {
            throw new IllegalArgumentException(INPUT_EXCEPTION_MESSAGE);
        }
    }
}
