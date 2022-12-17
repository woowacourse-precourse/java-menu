package menu.domain;

public class CoachMenu {
    private Coach coach;
    private String menu;

    private CoachMenu(Coach coach, String menu) {
        this.coach = coach;
        this.menu = menu;
    }

    public static CoachMenu from(Coach coach, String menu) {
        return new CoachMenu(coach, menu);
    }
}
