package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Coach {

    private final CoachName coachName;
    private final List<String> coachNotAteMenu;
    private final List<String> coachAteMenu = new ArrayList<>();

    public Coach(final CoachName coachName, final List<String> coachNotAteMenu) {
        validateCoachName(coachName);
        this.coachName = coachName;
        this.coachNotAteMenu = coachNotAteMenu;
    }

    private void validateCoachName(final CoachName coachName) {
        if (coachName.getName() == null){
            throw new IllegalArgumentException("이름은 널일 수 없습니다.");
        }
    }
    public boolean canEat(final String menu) {
        if (coachNotAteMenu.contains(menu)) {
            return false;
        }
        return !coachAteMenu.contains(menu);
    }

    public void eat(final String menu) {
        if (!canEat(menu)) {
            throw new IllegalArgumentException("코치는 이 음식을 먹을 수 없습니다.");
        }
        coachAteMenu.add(menu);
    }

    public List<String> coachToDto() {
        final List<String> dto = new ArrayList<>();
        dto.add(coachName.getName());
        dto.addAll(coachAteMenu);
        return dto;
    }
}