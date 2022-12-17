package menu.constans;

public enum Error {
    COACH_NAME_LENGTH("[ERROR] 코치 이름은 최소 2글자 최대 4글자 입니다."),
    COACH_NAMES_SIZE("[ERROR] 코치는 최소 2명 최대 5명 입력 가능합니다."),
    CANT_EAT_FOOD_SIZE("[ERROR] 코치가 먹지 못하는 음식은 최대 2개 입니다."),
    ALREADY_RECOMMEND("[ERROR] 이미 추천된 메뉴입니다."),
    CANT_EAT_FOOD_CANT_RECOMMEND("[ERROR] 먹지 못하는 메뉴는 추천할수 없습니다.");
    private final String message;

    Error(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
