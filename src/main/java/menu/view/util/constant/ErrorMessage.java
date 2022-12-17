package menu.view.util.constant;

public enum ErrorMessage {
    WRONG_LENGTH("[ERROR] 이름은 최소 2글자 이상 4글자 이하여야 한다."),
    LESS_COACH("[ERROR] 코치는 최소 2명 이상 입력해야 합니다."),
    MORE_COACH("[ERROR] 코치는 최대 5명 이하까지 입력 가능 합니다"),

    WRONG_SEP("[ERROR] 올바른 형식으로 입력하세요"),

    BLANK("[ERROR] 공백은 허용되지 않는다.");

    private final String message ;

    ErrorMessage(String message){
        this.message = message;
    }
    public String getMessage(){
        return this.message;
    }
}
