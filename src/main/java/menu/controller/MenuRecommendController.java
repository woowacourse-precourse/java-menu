package menu.controller;

import java.util.List;
import menu.repository.FoodRepository;
import menu.service.CoachService;
import menu.service.MenuRecommendService;
import menu.service.NotEatFoodService;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuRecommendController {

    private final CoachService coachService;
    private final MenuRecommendService menuRecommendService;
    private final NotEatFoodService notEatFoodService;

    public MenuRecommendController(CoachService coachService, MenuRecommendService menuRecommendService, NotEatFoodService notEatFoodService) {
        this.coachService = coachService;
        this.menuRecommendService = menuRecommendService;
        this.notEatFoodService = notEatFoodService;
    }

    public void run() {
        initData();
        OutputView.printRun();
        List<String> coachNames = keepReadCoach();
        addCoach(coachNames);
        addNotEatFoods(coachNames);
        OutputView.printResult(menuRecommendService.run(), coachService.findAllCoaches());
    }

    private void initData() {
        FoodRepository.init();
    }

    public void addCoach(List<String> coachNames) {
        coachService.addCoaches(coachNames);
    }

    public void addNotEatFoods(List<String> coachNames) {
        coachNames.stream()
                .forEach(coachName -> keepAddNotEatFood(coachName));
    }

    private List<String> keepReadCoach() {
        try {
            List<String> coachNames = InputView.readCoach();
            return coachNames;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return keepReadCoach();
        }
    }

    private void keepAddNotEatFood(String coachName) {
        try {
            notEatFoodService.addNotEatFoods(InputView.readNotEatFoodByCoach(coachName));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            keepAddNotEatFood(coachName);
        }
    }

}
