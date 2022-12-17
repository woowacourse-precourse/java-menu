package menu.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.CoachRepository;
import menu.service.MenuRecommendService;
import menu.utils.constants.Common;
import menu.view.InputView;
import menu.view.OutputView;

public class RecommendController {

    private final InputView inputView;
    private final OutputView outputView;
    private final MenuRecommendService recommendService;
    Map<String, Integer> categoryCounts = new HashMap<>();
    List<String> categories = new ArrayList<>();

    public RecommendController(InputView inputView, OutputView outputView, MenuRecommendService recommendService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.recommendService = recommendService;
    }

    public void run() {
        List<String> coachNames = getCoaches();
        getUnEatableFoodsPerCoach(coachNames);
        initCategoryCounts();
        executeRecommendPerCoach();
        outputView.resultOutput(categories);
    }

    private void initCategoryCounts() {
        for (Category category : Category.values()) {
            categoryCounts.put(category.getCategory(), 0);
        }
    }

    private void executeRecommendPerCoach() {
        for (int i = 0; i < Common.NUMBER_OF_DATE.getNumber(); i++) {
            Category category;
            do {
                category = Category.values()[Randoms.pickNumberInRange(1, 5) - 1];
            } while (categoryCounts.get(category.getCategory()) >= 2);
            categories.add(category.getCategory());
            for (Coach coach : CoachRepository.coaches()) {
                recommendService.recommend(coach, category);
            }
        }

    }

    private void getUnEatableFoodsPerCoach(List<String> coachNames) {
        for (String coachName : coachNames) {
            outputView.unEatableFoodOutput(coachName);
            List<String> unEatableFoods = inputView.readUnEatableFoods();
            outputView.emptyLine();
            CoachRepository.addCoach(new Coach(coachName, unEatableFoods));
        }
    }

    private List<String> getCoaches() {
        outputView.gameStartOutput();
        List<String> coaches = inputView.readCoachNames();
        outputView.emptyLine();
        return coaches;
    }
}
