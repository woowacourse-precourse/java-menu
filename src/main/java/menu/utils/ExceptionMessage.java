package menu.utils;

public enum ExceptionMessage {

    NOT_SATISFIED_NAME_LENGTH("코치님의 최소 2글자, 최대 4글자여야합니다."),
    NOT_SATISFIED_NUMBER_OF_COACH("식사는 최소 2분, 최대5 분까지 함께 하실 수 있습니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String get() {
        return String.format("[ERROR] %s", message);
    }
}
