package menu.utils.constants;

public enum InputMessage {

    READ_COACH_NAME("코치의 이름을 입력해 주세요. (, 로 구분)"),
    READ_COACH_BAN_FOODS("(이)가 못 먹는 메뉴를 입력해 주세요.");

    private final String message;

    InputMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }
}
