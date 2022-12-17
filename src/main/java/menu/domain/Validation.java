package menu.domain;

public class Validation {

    private static final String NUMBER_OF_COACHES_ERROR = "[ERROR] 코치는 최소 2명, 최대 5명을 입력해주세요.";
    private static final String NAME_SIZE_ERROR = "[ERROR] 코치의 이름은 최소 2글자, 최대 4글자로 입력해주세요.";

    public void validateNumberOfCoaches(String[] coaches) {
        if (coaches.length < 2 || coaches.length > 5) {
            throw new IllegalArgumentException(NUMBER_OF_COACHES_ERROR);
        }
    }

    public void validateNameSize(String[] coaches) {
        for (String coach: coaches) {
            if (coach.length() < 2 || coach.length() > 4) {
                throw new IllegalArgumentException(NAME_SIZE_ERROR);
            }
        }
    }
}
