package menu.view;

import menu.Coach;

public enum PrintMessages {
    SERVICE_START("점심 메뉴 추천을 시작합니다.\n"),
    INSERT_COACHES("코치의 이름을 입력해 주세요. (, 로 구분)"),
    INSERT_HATE_MENU(" (이)가 못 먹는 메뉴를 입력해 주세요.");

    private final String message;

    PrintMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public static String hateMenuBy(Coach coach) {
        return coach.getName() + INSERT_HATE_MENU.message;
    }
}
