package menu.DTO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import menu.domain.Coach;

public class CoachNameDTO {

    private static final int MAXIMUM_COACH_NUMBER = 5;
    private static final int MINIMUM_COACH_NUMBER = 2;
    private final List<Coach> coaches = new ArrayList<>();
    private static final CoachNameDTO coachNameDTO = new CoachNameDTO();

    private CoachNameDTO() {}

    public static CoachNameDTO getInstance() {
        return coachNameDTO;
    }

    public List<Coach> getCoaches() {
        return Collections.unmodifiableList(coaches);
    }

    public void setCoaches(final String nameInput) {
        coaches.clear();
        List<String> names = List.of(nameInput.split(","));

        names.forEach(name -> coaches.add(new Coach(name)));
        if (names.size() > MAXIMUM_COACH_NUMBER
                || names.size() < MINIMUM_COACH_NUMBER) {
            throw new IllegalArgumentException(
                    "[ERROR] 함께 식사하는 코치느 최소 2명, 최대 5명입니다.");
        }
    }
}
