package menu.controller;

import menu.domain.Ban;
import menu.domain.Coach;
import menu.domain.Result;
import menu.service.BanService;
import menu.service.CoachService;
import menu.service.ResultService;

public class MenuController {
    private Coach coach;
    private Ban ban;
    private Result result;
    private final CoachService coachService;
    private final BanService banService;
    private final ResultService resultService;

    public MenuController(CoachService coachService, BanService banService, ResultService resultService) {
        this.coachService = coachService;
        this.banService = banService;
        this.resultService = resultService;
    }

    public void start() {
        coach = coachService.initializeCoach();
        ban = banService.initializeBan(coach);
        result = resultService.initializeResult(coach);
    }

    public void select() {
        String category = resultService.pickCategory(result);
        for (String coachName : coach.getCoachNames()) {
            resultService.pickMenu(category, result, coachName, ban);
        }
    }

    public void finish() {
        resultService.printResult(result, coach);
    }
}
