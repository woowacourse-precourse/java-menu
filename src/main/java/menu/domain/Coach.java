package menu.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Coach {
    private final CoachName name;
    private final List<String> canNotEatMenus = new ArrayList<>();

    public Coach(CoachName name) {
        this.name = name;
    }

    public void addCanNotEatMenus(List<String> menus) {
        canNotEatMenus.addAll(menus);
    }

    public String getName() {
        return name.getName();
    }

    public boolean canEat(String menu) {
        return !canNotEatMenus.contains(menu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Coach)) {
            return false;
        }
        if (((Coach) obj).name.equals(this.name)) {
            return true;
        }
        return false;
    }
}