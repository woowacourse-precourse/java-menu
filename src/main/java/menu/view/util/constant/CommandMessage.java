package menu.view.util.constant;

public enum CommandMessage {
    START("점심 메뉴 추천을 시작합니다.\n"),

    REQUEST_NAME("코치의 이름을 입력해 주세요. (, 로 구분)"),
    REQUEST_EXCLUDE("(이)가 못 먹는 메뉴를 입력해 주세요."),
    EXECUTE_MESSAGE("메뉴 추천 결과입니다."),
    COMPLETE("추천을 완료했습니다.");

    private final String command ;

    CommandMessage(String command){
        this.command = command ;
    }

    public String getMessage(){
        return command ;
    }
}
