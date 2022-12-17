package menu.exception;

public class CustomIllegalArgumentException extends IllegalArgumentException {

    /**
     * 에러메시지에 [ERROR]를 확정적으로 추가하게하는 커스텀 에러
     *
     * @param message
     */
    public CustomIllegalArgumentException(String message) {
        super("[ERROR] " + message);
    }
}
