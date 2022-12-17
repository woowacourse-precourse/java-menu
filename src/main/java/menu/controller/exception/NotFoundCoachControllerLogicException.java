package menu.controller.exception;

public class NotFoundCoachControllerLogicException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "요청한 코치 관련 기능을 수행할 수 없습니다.";

    public NotFoundCoachControllerLogicException() {
        super(DEFAULT_MESSAGE);
    }
}
