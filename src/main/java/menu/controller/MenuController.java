package menu.controller;

import menu.domain.Coach;
import menu.service.CoachService;

public class MenuController {
    private Coach coach;
    private final CoachService coachService;

    public MenuController(CoachService coachService) {
        this.coachService = coachService;
    }

    public void start() {
        coach = coachService.initializeCoach();
    }
}
