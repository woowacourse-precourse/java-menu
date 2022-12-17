package menu.service;

import menu.domain.Categories;
import menu.domain.Coach;
import menu.domain.Coaches;
import menu.dto.CoachInputDTO;
import menu.dto.UnavailableMenuDTO;

import java.util.List;

public class MenuService {

    private Coaches coaches;
    private Categories categories;

    public void init() {
        coaches = new Coaches();
        categories = Categories.createCategoryList();
    }

    public void createCoaches(CoachInputDTO coachInputDTO) {
        List<String> coachNames = coachInputDTO.getCoachNames();
        for (String coachName : coachNames) {
            coaches.addCoach(Coach.createCoach(coachName));
        }
    }


    public List<String> findAllCoachNames() {
        return coaches.getAllCoachesNames();
    }

    public void addUnavailableMenus(String coachName, UnavailableMenuDTO unavailableMenuDTO) {
        Coach coach = coaches.findByName(coachName);
        coach.addUnavailableMenu(unavailableMenuDTO.getUnavailableMenus());
    }
}
