package menu.domain;

public class Coach {
    private final String name;

    public Coach(String name) {
        validateNameLength(name);
        this.name = name.trim();
    }

    private void validateNameLength(String name) {
        if (!isValidLength(name.length())) {
            throw new IllegalArgumentException("[ERROR] 이름은 2글자 ~ 4글자만 가능합니다.");
        }
    }

    private boolean isValidLength(int length) {
        return 2 <= length && length <= 4;
    }
}
