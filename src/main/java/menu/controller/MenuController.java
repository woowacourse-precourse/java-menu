package menu.controller;

import menu.domain.Ban;
import menu.domain.Coach;
import menu.service.BanService;
import menu.service.CoachService;

public class MenuController {
    private Coach coach;
    private Ban ban;
    private final CoachService coachService;
    private final BanService banService;

    public MenuController(CoachService coachService, BanService banService) {
        this.coachService = coachService;
        this.banService = banService;
    }

    public void start() {
        coach = coachService.initializeCoach();
        ban = banService.initializeBan(coach);
    }
}
