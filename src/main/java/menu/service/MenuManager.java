package menu.service;

import menu.domain.Coach;
import menu.domain.CoachRepository;
import menu.domain.WeeklyCategories;
import menu.dto.ResultDto;

import java.util.List;

public class MenuManager {

    private static final WeeklyCategories weeklyCategories = new WeeklyCategories();
    public void saveCoach(List<String> coachNames) {
        for (String coachName : coachNames) {
            CoachRepository.add(new Coach(coachName));
        }
    }

    public List<String> findAllCoachNames() {
        return CoachRepository.getAllNames();

    }

    public void saveHatingMenus(List<String> hatingMenus, String coachName) {
        Coach coach = CoachRepository.findByName(coachName);
        coach.addHateMenus(hatingMenus);
    }

    public ResultDto activateRecommendation() {
        weeklyCategories.pickCategories();
        CoachRepository.pickMenus(weeklyCategories.getCategoryList());
        ResultDto resultDto = new ResultDto(weeklyCategories.getCategoryList(), CoachRepository.getCompleteMenuDtos());
        return resultDto;
    }
}
