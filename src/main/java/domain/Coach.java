package domain;

public class Coach {

    private final String name;

    public Coach(String name) {
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameLength(String name) {
        if (name.length() >= 2 && name.length() <= 4) {
            return;
        }
        throw new IllegalArgumentException("[ERROR] 코치 이름은 최소 2글자 이상 최대 4글자 이하로 입력해주세요");
    }

    public String getName() {
        return name;
    }
}
