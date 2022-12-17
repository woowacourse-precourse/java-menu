package menu.service;

import menu.domain.Coach;

import java.util.List;

public class CoachServiceImpl implements CoachService {

    private final List<Coach> coaches;

    public CoachServiceImpl(List<Coach> coaches) {
        this.coaches = coaches;
    }

    public List<Coach> getCoaches() {
        return coaches;
    }

    public void addRefuseMenuToCoach(Coach coach, List<String> refuseMenus) {
        for (Coach coach1 : coaches) {
            if (coach1 == coach) {
                coach.getRefuseMenus().addAll(refuseMenus);
            }
        }
    }
}
