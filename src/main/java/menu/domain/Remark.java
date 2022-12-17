package menu.domain;

import java.util.List;

public class Remark {
    private final Coach coach;
    private final List<List<String>> categoryMenu;

    private Remark(Coach coach, List<List<String>> categoryMenu) {
        this.coach = coach;
        this.categoryMenu = categoryMenu;
    }

    public static Remark of(Coach coach, List<List<String>> categoryMenu) {
        return new Remark(coach, categoryMenu);
    }

    public Coach getCoach() {
        return coach;
    }

    public List<List<String>> getCategoryMenu() {
        return categoryMenu;
    }

    @Override
    public String toString() {
        return coach.toString() + categoryMenu.toString();
    }
}
