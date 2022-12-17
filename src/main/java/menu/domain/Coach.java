package menu.domain;

public class Coach {

    private final String name;

    public Coach(String name) {
        if(!isValid(name)){
            throw new IllegalArgumentException("코치의 이름은 최소 2글자, 최대 4글자입니다.");
        }
        this.name = name;
    }

    private static boolean isValid(String name) {
        return 2 <= name.length() && name.length() <= 4;
    }
}
