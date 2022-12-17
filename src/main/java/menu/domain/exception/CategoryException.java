package menu.domain.exception;

public enum CategoryException {
    OUT_OF_DUPLICATE_LIMIT("같은 카테고리는 최대 2개만 허용됩니다.");
    private final String exceptionMessage;

    CategoryException(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public String getExceptionMessage() {
        return this.exceptionMessage;
    }
}
