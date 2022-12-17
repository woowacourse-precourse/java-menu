package menu.domain;

import java.util.ArrayList;
import java.util.List;
import menu.util.NullValidator;

public class Coach {

    private static final String CANNOT_EAT_MESSAGE = "먹을 수 없습니다";
    private final CoachName coachName;
    private final List<String> notEatMenus;
    private final List<String> ateMenu = new ArrayList<>();

    public Coach(CoachName coachName, List<String> notEatMenus) {
        validateCoachName(coachName);
        validateNotEatMenus(notEatMenus);
        this.coachName = coachName;
        this.notEatMenus = notEatMenus;
    }

    private void validateNotEatMenus(List<String> notEatMenus) {
        NullValidator.throwIfNull(notEatMenus);
    }

    private void validateCoachName(CoachName coachName) {
        NullValidator.throwIfNull(coachName);
    }

    public boolean canEat(String menu) {
        if (notEatMenus.contains(menu)) {
            return false;
        }
        return !ateMenu.contains(menu);
    }

    public void eat(String menu) {
        if (!canEat(menu)) {
            throw new IllegalArgumentException(CANNOT_EAT_MESSAGE);
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
