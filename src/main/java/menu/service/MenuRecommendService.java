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

    public Category recommendCategory() {
        Category recommendedCategory = RandomCategoryGenerator.generate();
        while (thisWeekRecommendedCategory.isRecommendCategoryCountOverTwo(recommendedCategory)) {
            recommendedCategory = RandomCategoryGenerator.generate();
        }
        thisWeekRecommendedCategory.updateRecommendCategory(recommendedCategory);
        return recommendedCategory;
    }

    public void recommendMenu(List<String> coachNames, Category recommendedCategory) {
        for (String coachName : coachNames) {
            Coach findCoach = coachRepository.findByCoachName(coachName);
            String recommendMenu = menuRecommendMachine.recommend(recommendedCategory);
            while (!findCoach.validateRecommendMenu(recommendMenu)) {
                recommendMenu = menuRecommendMachine.recommend(recommendedCategory);
            }
            findCoach.updateAlreadyEatFood(recommendMenu);
        }
    }

    public List<String> getRecommendMenusByCoachName(String coachName) {
        Coach findCoach = coachRepository.findByCoachName(coachName);
        return findCoach.getAlreadyEatenFoods();
    }
}
