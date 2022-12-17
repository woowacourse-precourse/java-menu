package menu.repository;

import java.util.LinkedHashMap;
import java.util.Map;
import menu.domain.Coach;
import menu.domain.CoachMenus;
import menu.domain.Coaches;
import menu.domain.Menu;

public class CoachRepository {

    private static final Map<Coach, CoachMenus> coachRepository = new LinkedHashMap<>();

    public void setCoach(Coaches coaches) {
        coaches.getCoaches().stream()
                .forEach(coach -> coachRepository.put(coach, new CoachMenus()));
    }

    public void put(Coach coach, Menu menu) {
        coachRepository.put(coach,coachRepository.get(coach)).addMenu(menu);
    }

}
