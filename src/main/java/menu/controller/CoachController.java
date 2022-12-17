package menu.controller;

import menu.model.service.CoachService;

import java.util.List;

/**
 * @author 최원용
 * @version 2.0.0
 * @Created by 최원용 on 2022. 12. 17.
 */
public class CoachController {

    private final CoachService coachService;

    public CoachController(CoachService coachService) {
        this.coachService = coachService;
    }

    public List<String> getCoachesName() {
        return coachService.getCoaches();
    }
}
