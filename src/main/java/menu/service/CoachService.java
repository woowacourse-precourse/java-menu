package menu.service;

import menu.domain.Coach;
import menu.domain.Menu;
import menu.repository.CoachRepository;

import java.util.List;

public class CoachService {

    private final CoachRepository coachRepository = new CoachRepository();

    public Coach addCoach(String name) {
        Coach coach = new Coach(name);
        coachRepository.insertCoach(coach);
        return coach;
    }

    public void inputHateMenus(Coach coach, List<Menu> hateMenus) {
        coach.addHateMenus(hateMenus);
        coachRepository.updateCoach(coach);
    }

    public void inputRecommendedMenus(Coach coach, List<Menu> recommendedMenus) {
        coach.addRecommendMenus(recommendedMenus);
        coachRepository.updateCoach(coach);
    }

    public List<Coach> findAll() {
        return coachRepository.findAll();
    }

}
