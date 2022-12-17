package exception;

public class CommonException {
    public static void validateNumericOnly(String number) {
        if (!number.matches("[0-9]+")) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }
    }

    private static void validateEmptyString(String value) {
        if (value.isBlank()) {
            throw new IllegalArgumentException("비어있는 문자인지 확인해주세요.");
        }
    }
}
