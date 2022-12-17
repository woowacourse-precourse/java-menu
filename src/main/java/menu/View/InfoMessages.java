package menu.View;

public enum InfoMessages {

    START("점심 메뉴 추천을 시작합니다."),
    INPUT_COACH_NAMES("코치의 이름을 입력해 주세요. (, 로 구분)"),
    INPUT_EXCLUDE_MENUS("(이)가 못 먹는 메뉴를 입력해 주세요."),
    RESULT("메뉴 추천 결과입니다."),
    FINISH("추천을 완료했습니다.");

    private String message;

    InfoMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void println() {
        System.out.println(message);
    }

    public void print() {
        System.out.print(message);
    }
}
