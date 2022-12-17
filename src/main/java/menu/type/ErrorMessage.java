package menu.type;

public enum ErrorMessage {
    COACH_SIZE_ERROR("[ERROR] 코치는 최소 2명 이상 입력해야 합니다."),
    COACH_NAME_ERROR("[ERROR] 코치의 이름은 2글자부터 4글자까지여야합니다."),
    COACH_INPUT_ERROR("[ERROR] 코치의 이름은 ,를 기준으로 입력해주세요."),
    NONEXISTENT_MENU_ERROR("[ERROR] 존재하지 않는 메뉴를 입력하셨습니다."),
    OVER_MENU_COUNT_ERROR("[ERROR] 먹지 못하는 메뉴는 최대 2개까지 입력이 가능합니다."),
    DUPLICATED_MENU_ERROR("[ERROR] 중복된 메뉴를 입력하셨습니다."); // 요구사항 내 없지만 프로그램의 특성을 고려했을 때 이를 반영하여 에러 항목 추가

    private String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
