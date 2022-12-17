package menu.di;

import java.util.ArrayList;
import java.util.List;
import menu.domain.Coach;
import menu.domain.CoachName;

class CoachMapper {

    private final List<Coach> coaches = new ArrayList<>();

    CoachMapper(List<String> names, List<List<String>> notEatMenus) {
        for (int i = 0; i < names.size(); i++) {
            String name = names.get(i);
            List<String> notEatMenu = notEatMenus.get(i);
            coaches.add(new Coach(new CoachName(name), notEatMenu));
        }
    }

    List<Coach> toCoaches() {
        return coaches;
    }
}
