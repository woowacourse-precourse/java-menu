package menu.domain;

public class Coach {
    private final String name;
    private final InedibleMenu inedibleMenu;
    private final EatenMenu eatenMenu = new EatenMenu();

    public Coach(String name, String inedibleMenu) {
        this.inedibleMenu = new InedibleMenu(inedibleMenu);
        this.name = name;
    }
}
