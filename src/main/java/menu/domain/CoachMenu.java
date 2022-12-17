package menu.domain;

import java.util.Objects;

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

    public Coach getCoach() {
        return coach;
    }

    public String getMenu() {
        return menu;
    }

    @Override
    public int hashCode() {
        return Objects.hash(coach, menu);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof CoachMenu)) {
            return false;
        }
        if (((CoachMenu) obj).coach.equals(this.coach)
        && ((CoachMenu) obj).menu.equals(this.menu)) {
            return true;
        }
        return false;
    }
}
