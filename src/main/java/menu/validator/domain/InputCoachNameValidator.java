package menu.validator.domain;

public class InputCoachNameValidator {
    public static void validate(String coachName) {
        validateCoachNameLengthOutOfRange(coachName);
    }
    
    private static void validateCoachNameLengthOutOfRange(String coachName) {
        if (coachName.length() < 2 || coachName.length() > 4) {
            throw new IllegalArgumentException("[ERROR] 코치 이름의 길이는 2~5의 길이를 벗어날 수 없습니다.");
        }
    }
}
