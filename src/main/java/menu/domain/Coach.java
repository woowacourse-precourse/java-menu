package menu.domain;

public class Coach {
    private final String name;
    private final InedibleMenu inedibleMenu;

    public Coach(String name, String inedibleMenu) {
        this.inedibleMenu = new InedibleMenu(inedibleMenu);
        this.name = name;
    }
}
