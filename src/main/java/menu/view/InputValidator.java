package menu.view;

public class InputValidator {

    private static final String EMPTY_INPUT = "입력된 값이 없습니다.";
    private static final String INVALID_KOREAN_FORMAT = "한글을 올바르게 입력해주세요.";
    private static final String NON_KOREAN_CHARACTER_INCLUDED = "(.*)[^가-힇](.*)";

    public void validate(String input) {
        validateBlank(input);
        validateKorean(input);
    }

    private void validateBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(EMPTY_INPUT);
        }
    }

    private void validateKorean(String input) {
        if (input.matches(NON_KOREAN_CHARACTER_INCLUDED)) {
            throw new IllegalArgumentException(INVALID_KOREAN_FORMAT);
        }
    }
}
