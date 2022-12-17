package menu.domain;

public class Coach {
    private final String name;
    private final Menus noEat;
    private final Menus eaten;

    public Coach(String name, Menus noEat, Menus eaten) {
        validate(name);
        this.name = name;
        this.noEat = noEat;
        this.eaten = new Menus();
    }

    private void validate(String name) {
        if (name.length() < )
    }
}
