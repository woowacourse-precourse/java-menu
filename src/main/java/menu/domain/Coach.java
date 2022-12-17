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

    public boolean containsName(final String coachName) {
        return name.equals(coachName);
    }
}
