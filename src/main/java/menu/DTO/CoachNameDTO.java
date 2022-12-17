package menu.DTO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import menu.domain.Coach;

public class CoachNameDTO {

    private final List<Coach> coaches = new ArrayList<>();
    private static final CoachNameDTO coachNameDTO = new CoachNameDTO();

    private CoachNameDTO() {}

    public static CoachNameDTO getInstnace() {
        return coachNameDTO;
    }

    public List<Coach> getCoaches() {
        return Collections.unmodifiableList(coaches);
    }

    public void setCoaches(String nameInput) {
        List<String> names = List.of(nameInput.split(","));
        names.forEach(name -> coaches.add(new Coach(name)));
    }
}
