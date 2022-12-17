package menu.service;

import menu.domain.Coach;
import menu.domain.Menu;
import menu.repository.CoachRepository;

import java.util.List;
import java.util.Optional;

public class CoachService {

    private final CoachRepository coachRepository = new CoachRepository();

    public Coach addCoach(String name){
        Coach coach = new Coach(name);
        coachRepository.insertCoach(coach);
        return coach;
    }

    public void inputHateMenus(Coach coach, List<Menu> hateMenus) {
        coachRepository.removeCoach(coach.getName());
        coach.addHateMenus(hateMenus);
        coachRepository.insertCoach(coach);
    }

}
