package menu.validator;

public enum ErrorMessages {
    ERROR("[ERROR]"),
    INVALID_COACH("코치 이름은 2글자 이상 4글자 이하 입니다."),
    INVALID_MENU("등록할 수 없는 메뉴입니다.");

    private final String content;

    ErrorMessages(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return content;
    }
}
