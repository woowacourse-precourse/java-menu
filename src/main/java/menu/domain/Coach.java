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
}