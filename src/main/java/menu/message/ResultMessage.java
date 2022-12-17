package menu.message;

public enum ResultMessage {
    RESULT_INTRODUCTION_MESSAGE("메뉴 추천 결과입니다."),
    HEAD_OF_LINE("[ "),
    TAIL_OF_LINE(" ]"),
    DELIMITER(" | "),
    CLASSIFICATION("분류"),
    CATEGORY("카테고리");

    String message;

    ResultMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
