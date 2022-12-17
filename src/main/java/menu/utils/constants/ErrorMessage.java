package menu.utils.constants;

public enum ErrorMessage {
    ERROR_MESSAGE_TAG("[ERROR] "),
    NOT_VALID_COACH_COUNT(ERROR_MESSAGE_TAG.getMessage()+"코치는 최소 2명에서 최대 5명을 입력해야 합니다."),
    NOT_VALID_FOOD_BAN_COUNT(ERROR_MESSAGE_TAG.getMessage()+"코치는 최소 0개에서 최대 2개의 음식을 못먹습니다.");

    private final String message;

    ErrorMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }
}
