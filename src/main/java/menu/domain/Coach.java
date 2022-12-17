package menu.domain;

public class Coach {
    private final String name;
    private ExcludeMenu excludeMenu;

    public Coach(final String name) {
        this.name = name.trim();
    }

    public String getName() {
        return name;
    }
}
