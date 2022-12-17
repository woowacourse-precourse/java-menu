package menu.service;

import menu.model.Coach;
import menu.model.Menu;
import menu.repository.CoachRepository;

import java.util.List;

/**
 * @Author : jeeseob
 * @CreateAt : 2022/12/17
 */
public class CoachService {
    private final CoachRepository coachRepository;

    public CoachService() {
        this.coachRepository = CoachRepository.getInstance();
    }

    public void addCoach(String name, List<Menu> hateMenus) {
        coachRepository.addCoach(name, hateMenus);
    }

    public List<Coach> findAll() {
        return coachRepository.findAll();
    }
}
