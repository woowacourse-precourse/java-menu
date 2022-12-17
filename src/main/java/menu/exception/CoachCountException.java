package menu.exception;

public class CoachCountException extends IllegalArgumentException {
    private static final String ERROR = "인원은 최소 2명 최대 5명이어야 합니다.";

    public CoachCountException() {
        super(ERROR);
    }
}
