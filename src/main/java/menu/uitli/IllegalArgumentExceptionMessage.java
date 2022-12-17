package menu.uitli;

/**
 * @Author : jeeseob
 * @CreateAt : 2022/12/17
 */
public enum IllegalArgumentExceptionMessage {
    INPUT_COACH_LENGTH("[ERROR] 코치는 최소 2명 이상 입력해야 합니다.")
    ;

    private final String message;

    IllegalArgumentExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR] " + message;
    }
}