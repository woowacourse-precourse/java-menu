package menu.domain;

public class CoachName {
    private final String name;

    private final String NAME_SIZE_INVALID = "[ERROR] 코치의 이름은 2글자에서 4글자만 가능합니다.";

    public CoachName(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name.length() < 2 || name.length() > 5) {
            throw new IllegalArgumentException(NAME_SIZE_INVALID);
        }
    }

    public String getName() {
        return name;
    }
}
