package menu.domain;

import java.util.ArrayList;
import java.util.List;
public class CoachMapper {

    private final List<Coach> coaches = new ArrayList<>();

    public CoachMapper(final List<String> names, final List<List<String>> notAteMenu) {
        for (int i = 0; i < names.size(); i++) {
            coaches.add(Coach.of(CoachName.of(names.get(i)), notAteMenu.get(i)));
        }
    }

    public List<Coach> mapToCoach() {
        return coaches;
    }
}