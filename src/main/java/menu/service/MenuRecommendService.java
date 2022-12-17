package menu.service;

import menu.model.Category;
import menu.model.DayOfTheWeek;
import menu.model.MenuRecommendMachine;
import menu.model.RandomCategoryGenerator;
import menu.model.coach.Coach;
import menu.model.coach.CoachRepository;

import java.util.List;

public class MenuRecommendService {

    private final CoachRepository coachRepository;
    private final MenuRecommendMachine menuRecommendMachine;

    public MenuRecommendService() {
        this.coachRepository = new CoachRepository();
        this.menuRecommendMachine = new MenuRecommendMachine();
    }

    public void generateCoachByCoachName(List<String> coachNames) {
        for (String coachName : coachNames) {
            Coach coach = new Coach(coachName);
            coachRepository.saveCoach(coach);
        }
    }

    public void saveCannotEatFoods(List<String> coachNames, List<String> cannotEatFoods) {
        for (String coachName : coachNames) {
            Coach findCoach = coachRepository.findByCoachName(coachName);
            findCoach.updateCannotEatFoods(cannotEatFoods);
        }
    }

    public List<DayOfTheWeek> generateDayOfTheWeeks() {
        return DayOfTheWeek.getDaysOfTheWeek();
    }

}
