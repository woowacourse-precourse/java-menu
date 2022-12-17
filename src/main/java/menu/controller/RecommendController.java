package menu.controller;

import menu.domain.CoachGroup;
import menu.domain.Food;
import menu.service.RecommendService;
import menu.utils.Category;
import menu.utils.Weekend;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class RecommendController {

    private final InputView inputView;
    private final OutputView outputView;
    private final RecommendService recommendService;

    public RecommendController() {
        this.outputView = new OutputView();
        this.inputView = new InputView(outputView);
        this.recommendService = new RecommendService();
    }

    public void run() {
        outputView.printInitRecommend();
        CoachGroup coachGroup = repeat(inputView::readCouchName);

        List<Category> categories = new ArrayList<>();

        couchDenyFood(coachGroup);

        IntStream.range(0, Weekend.size())
                .mapToObj(index -> recommendService.getCategory()).forEach(category -> {
                    categories.add(category);
                    couchRecommendedFood(coachGroup, category);
                });

        outputView.printResult(coachGroup, categories);
    }

    private void couchRecommendedFood(CoachGroup coachGroup, Category category) {
        IntStream.range(0, coachGroup.size()).mapToObj(coachGroup::get)
                .forEach(couch -> {
                    Food food = recommendService.getFood(category, couch);
                    couch.recommend(food);
                });
    }

    private void couchDenyFood(CoachGroup coachGroup) {
        IntStream.range(0, coachGroup.size()).mapToObj(coachGroup::get)
                .forEach(couch -> {
                    List<Food> foods = repeat(() -> inputView.readCannotFood(couch));
                    couch.denyFood(foods);
                });
    }

    private <T> T repeat(Supplier<T> read) {
        try {
            return read.get();
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println(e.getMessage());
            return repeat(read);
        }
    }
}
