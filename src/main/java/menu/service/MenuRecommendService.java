package menu.service;

import menu.model.*;
import menu.model.coach.Coach;
import menu.model.coach.CoachRepository;

import java.util.List;

public class MenuRecommendService {

    private final CoachRepository coachRepository;
    private final MenuRecommendMachine menuRecommendMachine;
    private final ThisWeekRecommendedCategory thisWeekRecommendedCategory;

    public MenuRecommendService() {
        this.coachRepository = new CoachRepository();
        this.menuRecommendMachine = new MenuRecommendMachine();
        this.thisWeekRecommendedCategory = new ThisWeekRecommendedCategory();
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

    public void recommendMenu(List<String> coachNames) {
        Category recommendedCategory = RandomCategoryGenerator.generate();
        thisWeekRecommendedCategory.updateRecommendCategory(recommendedCategory);

        for (String coachName : coachNames) {
            Coach findCoach = coachRepository.findByCoachName(coachName);
            String recommendMenu = menuRecommendMachine.recommend(recommendedCategory);
            while (!findCoach.validateRecommendMenu(recommendMenu)) {
                retry(recommendedCategory);
            }
        }
    }

    private void retry(Category recommendedCategory) {
        menuRecommendMachine.recommend(recommendedCategory);
    }
}
