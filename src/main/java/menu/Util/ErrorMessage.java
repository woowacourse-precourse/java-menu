package menu.Util;

public enum ErrorMessage {
    CoachNumber("[ERROR] 밥을 같이 먹는 코치는 2명 이상 5명 이하입니다."),
    Allergic("[ERROR] 못먹는 음식은 0개 이상 2개 이하여야 합니다!"),
    CoachNameSize("[ERROR] 이름은 2글자 이상 4글자 이하여야 합니다!"),
    NoSuchFood("[ERROR] 못먹는 음식이 리스트에 없습니다! 다른 못먹는 음식을 입력해주세요");

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
