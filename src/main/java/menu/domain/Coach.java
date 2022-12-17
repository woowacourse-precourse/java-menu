package menu.domain;


public class Coach {
    private final String name;

    public Coach(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name.length() < 2 || name.length() > 4) {
            throw new IllegalArgumentException("코치의 이름은 2~4글자여야 합니다.");
        }
    }
}
