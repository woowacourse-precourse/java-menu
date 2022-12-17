package menu.dto;

import java.util.Collections;
import java.util.List;
import menu.domain.Menu;

public class CoachDto {
    private final String name;
    private final List<Menu> cantEatMenus;

    public CoachDto(String name, List<Menu> cantEatMenus) {
        this.name = name;
        this.cantEatMenus = cantEatMenus;
    }

    public String getName() {
        return name;
    }

    public List<Menu> getCantEatMenus() {
        return Collections.unmodifiableList(cantEatMenus);
    }
}
