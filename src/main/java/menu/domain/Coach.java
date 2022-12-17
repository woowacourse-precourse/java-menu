package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Coach {

    private final CoachName coachName;
    private final List<String> notEatMenus;
    private final List<String> ateMenu = new ArrayList<>();

    public Coach(CoachName coachName, List<String> notEatMenus) {
        this.coachName = coachName;
        this.notEatMenus = notEatMenus;
    }

    public boolean canEat(String menu) {
        if (notEatMenus.contains(menu)) {
            return false;
        }
        return !ateMenu.contains(menu);
    }

    public void eat(String menu) {
        if (!canEat(menu)) {
            throw new IllegalArgumentException("먹을 수 없습니다");
        }
        ateMenu.add(menu);
    }

    public List<String> toDto() {
        List<String> dto = new ArrayList<>();
        dto.add(coachName.getName());
        dto.addAll(ateMenu);
        return dto;
    }
}
