package menu.domain;

public class CoachExcludeMenu {
    private final Coach coach;
    private final ExcludeMenu excludeMenu;

    public CoachExcludeMenu(final Coach coach, final ExcludeMenu excludeMenu) {
        this.coach = coach;
        this.excludeMenu = excludeMenu;
    }

    public ExcludeMenu getMenu() {
        return excludeMenu;
    }

    public boolean isPossibleToEat(final String menuName) {
        return !excludeMenu.containsMenuName(menuName);
    }

    public Coach getCoach() {
        return coach;
    }
}
