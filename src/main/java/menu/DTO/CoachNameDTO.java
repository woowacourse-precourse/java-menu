package menu.DTO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import menu.domain.Coach;

public class CoachNameDTO {

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
    }
}
