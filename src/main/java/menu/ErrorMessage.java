package menu;

public enum ErrorMessage {
    PREFIX("[ERROR] "),
    COACH_NAME_RANGE("코치의 이름은 두글자 이상 네글자 이하여야 합니다."),
    COACH_AMOUNT_RANGE("코치는 두명 이상 다섯명 이하로 입력 가능합니다."),
    HATE_AMOUNT("싫어하는 음식은 두개 이하로 입력해야 합니다."),
    INPUT_IN_LIST("목록에 있는 음식을 입력해야 합니다."),
    NON_DUPLICATE("중복되는 이름을 입력할 수 없습니다.");

    String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String toString() {
        return PREFIX.message + this.message;
    }
}
