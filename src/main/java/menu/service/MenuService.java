package menu.service;

import menu.domain.Categories;
import menu.domain.Coach;
import menu.domain.Coaches;
import menu.dto.CoachInputDTO;

import java.util.List;

public class MenuService {

    private Coaches coaches;
    private Categories categories;

    public void createCoaches(CoachInputDTO coachInputDTO) {
        List<String> coachNames = coachInputDTO.getCoachNames();
        for (String coachName : coachNames) {
            coaches.addCoach(Coach.createCoach(coachName));
        }
    }



}
