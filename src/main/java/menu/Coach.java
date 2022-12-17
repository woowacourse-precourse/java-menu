package menu;

public class Coach {

    private final String name;

    public Coach(String name) {
        validName(name);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    private void validName(String input) {
        if (input.length() > 4 || input.length() < 2) {
            throw new IllegalArgumentException("코치의 이름은 2~4 글자 입니다.");
        }
    }
}
