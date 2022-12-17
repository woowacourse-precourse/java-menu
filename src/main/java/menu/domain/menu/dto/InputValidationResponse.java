package menu.domain.menu.dto;

public class InputValidationResponse {
    private final boolean isValid;
    private String message;

    public InputValidationResponse(boolean isValid) {
        this.isValid = isValid;
    }

    public InputValidationResponse(boolean isValid, String message) {
        this.isValid = isValid;
        this.message = message;
    }

    public boolean isValid() {
        return isValid;
    }

    public String getMessage() {
        return message;
    }
}
