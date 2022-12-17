package menu.domain;

public class Name {

    private final String name;
    public Name(String name) {
        validateLength(name);
        this.name = name;
    }

    private void validateLength(String name) {
        if (name.length() < 2) {
            throw new IllegalArgumentException("이름 길이가 너무 짧습니다");
        }
        if (name.length() > 4) {
            throw new IllegalArgumentException("이름 길이가 너무 깁니다");
        }
    }

    public String getName() {
        return name;
    }
}
