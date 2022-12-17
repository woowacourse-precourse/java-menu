package menu.service;

import menu.domain.Coach;

import java.util.List;

public interface CoachService {

    List<Coach> getCoaches();
    void addRefuseMenuToCoach(Coach coach, List<String> refuseMenus);
}
