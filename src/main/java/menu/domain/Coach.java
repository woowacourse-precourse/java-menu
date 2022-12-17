package menu.domain;

import java.util.List;

public class Coach {
    private final String name;
    private final EatHistory eatHistory;
    private final List<Menu> cantEat;
    public Coach(String name, EatHistory eatHistory, List<Menu> cantEat) {
        this.name = name;
        this.eatHistory = eatHistory;
        this.cantEat = cantEat;
    }

    public String getName() {
        return name;
    }

    public EatHistory getEatHistory() {
        return eatHistory;
    }

    public List<Menu> getCantEat() {
        return cantEat;
    }
}
