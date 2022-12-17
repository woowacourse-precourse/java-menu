package menu.utils;

public enum ExceptionMessage {

    NOT_SATISFIED_NAME_LENGTH("코치님의 최소 2글자, 최대 4글자여야합니다."),
    NOT_SATISFIED_NUMBER_OF_COACH("식사는 최소 2분, 최대5 분까지 함께 하실 수 있습니다."),
    NOT_FIND_MENU("추천 목록에 없는 메뉴입니다. 메뉴 이름을 확인하시거나 빈값을 입력해주세요."),
    OVER_MAX_PICKY_FOOD("먹지 못하는 메뉴는 2개까지만 입력 가능합니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String get() {
        return String.format("[ERROR] %s", message);
    }
}
