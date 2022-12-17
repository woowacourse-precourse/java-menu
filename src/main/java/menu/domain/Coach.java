package menu.domain;

public class Coach {
    private String name;

    Coach(String name) {
        this.name = name;
    }
    public static Coach of(String userName) {
        return new Coach(userName);
    }

    public String getName() {
        return name;
    }
}
