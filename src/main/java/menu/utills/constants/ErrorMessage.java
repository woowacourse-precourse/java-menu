package menu.utills.constants;

public enum ErrorMessage {
    OUT_OF_RANGE("%d이상 %d이하의 갯수만 입력 가능합니다."),
    UNACCEPTABLE_INPUT("보기에 있는 값만 입력가능 합니다."),
    LENGTH_ERROR("%d이상, %d이하 글자수의 이름만 입력가능 합니다."),
    DUPLICATED("중복되지 않은 값만 입력가능 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

}
