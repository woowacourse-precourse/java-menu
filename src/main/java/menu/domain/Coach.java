package menu.domain;

public class Coach {
    private String name;

    public Coach(String name) {
        if(!(2 <= name.length() && name.length() <= 4)) {
            throw new IllegalArgumentException("코치의 이름은 2글자 이상 4글자 이하입니다.");
        }
        this.name = name;
    }
}
