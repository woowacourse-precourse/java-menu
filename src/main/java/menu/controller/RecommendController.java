package menu.controller;

import menu.domain.Category;
import menu.domain.Couch;
import menu.domain.Food;
import menu.service.RecommendService;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

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
        List<Couch> couches = repeat(inputView::readCouchName);
        List<Category> categories = new ArrayList<>();
        couches.forEach(couch -> {
            List<Food> foods = repeat(() -> inputView.readCannotFood(couch));
            foods.forEach(couch::denyFood);
        });

        for (int i = 0; i < 5; i++) {
            Category category = recommendService.getCategory();
            categories.add(category);
            couches.forEach(couch -> {
                Food food = recommendService.getFood(category, couch);
                couch.eatFood(food);
            });
        }

        outputView.printResult(couches, categories);

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
