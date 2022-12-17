package menu.domain.menu.exception.errorCode;

public enum MenuErrorCode {

    CATEGORY_NOT_FOUND("해당 카테고리는 존재하지 않습니다.");

    private final String message;

    MenuErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
