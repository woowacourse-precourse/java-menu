package menu.controller;

import menu.domain.Category;
import menu.domain.Coach;
import menu.service.CategoryService;
import menu.service.CoachService;
import menu.service.RecommendationService;
import menu.view.InputView;
import menu.view.OutputView;
import menu.view.constant.InputPhrase;
import menu.view.constant.OutputPhrase;

import java.util.List;

public class MainController {
    private static class InstanceHolder {
        private static final MainController INSTANCE = new MainController();
    }

    private InputView inputView = InputView.getInstance();
    private OutputView outputView = OutputView.getInstance();
    private CategoryService categoryService = CategoryService.getInstance();
    private RecommendationService recommendationService = RecommendationService.getInstance();
    private CoachService coachService = CoachService.getInstance();

    private MainController(){}

    public static MainController getInstance() {
        return MainController.InstanceHolder.INSTANCE;
    }

    public void start() {
        outputView.printPhrase(OutputPhrase.START.getPhrase());
    }

    public void registerCoach() {
        List<String> coaches = Requester.requestStringListInput(() -> {
            outputView.printPhrase(InputPhrase.COACH_INPUT.getPhrase());
            return inputView.readStringList();
        });
        coachService.registerCoach(coaches);
    }

    public void registerInedibleFood() {
        List<String> coaches = coachService.findAllCoaches();
        for (String coach : coaches) {
            List<String> inEdibleFoods = Requester.requestStringListInput(() -> {
                outputView.printPhrase(InputPhrase.COACH_PREFERENCE.getPhrase(), coach);
                return inputView.readStringList();
            });
            coachService.registerInedibleFoodByCoach(coach, inEdibleFoods);
        }
    }

    public void recommend() {
        List<String> coaches = coachService.findAllCoaches();
        coaches.forEach(recommendationService::recommend);
    }

    public void showRecommendations() {
        outputView.printRecommendations(
                recommendationService.findRecommendedCategories(),
                recommendationService.findAllRecommendation()
        );
    }

    public void finish() {
        outputView.printPhrase(OutputPhrase.FINISH.getPhrase());
    }
}
