package menu.exception;

public class CannotRecommendMenuException extends RuntimeException {

    public CannotRecommendMenuException() {
        super("[ERROR] 같은 음식이 2개 이상 존재하면 안됩니다.");
    }
}
