package menu.view;

public enum ErrorMessage {
    OVER_CATEGORY("똑같은 카테고리를 3회 이상 먹을 수 없습니다"),
    ALREADY_EAT("똑같은 메뉴를 먹을 수 없습니다"),
    CANT_EAT("못먹는 음식입니다."),
    OUT_OF_RANGE_MEMBER_NAME("코치 이름 길이는 2 이상 4 이하여야 합니다"),
    OUT_OF_RANGE_MEMBER("코치 이름을 2이상 5이하의 개수로 입력해 주세요"),
    OUT_OF_RANGE_CANT_EAT("못먹는 음식을 0이상 2 이하의 개수로 입력해 주세요");
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
