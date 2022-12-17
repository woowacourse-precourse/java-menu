package menu.Util;

public enum SystemMessage {
    Invitation("점심 메뉴 추천을 시작합니다.\n" +
            "\n" +
            "코치의 이름을 입력해 주세요. (, 로 구분)"),
    Allergy("(이)가 못 먹는 메뉴를 입력해 주세요."),
    Final("메뉴 추천 결과입니다.\n" +
            "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]"),
    Category("카테고리"),
    End("추천을 완료했습니다.");

    private String message;

    SystemMessage(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
