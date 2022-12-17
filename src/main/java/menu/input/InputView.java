package menu.input;

import menu.type.ValidationType;

public class InputView {

    public void validate(ValidationType validationType, String input) {
        if (!ValidationType.validate(validationType, input)) {
            String errorMessage = validationType.getErrorMessage();
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
