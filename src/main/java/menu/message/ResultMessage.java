package menu.message;

public enum ResultMessage {
    RESULT_INTRODUCTION_MESSAGE("메뉴 추천 결과입니다."),
    HEAD_OF_LINE("[ "),
    TAIL_OF_LINE(" ]"),
    DELIMITER(" | "),
    CLASSIFICATION("구분"),
    CATEGORY("카테고리"),
    RESULT_FINISH_MESSAGE("추천을 완료했습니다.");

    String message;

    ResultMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
