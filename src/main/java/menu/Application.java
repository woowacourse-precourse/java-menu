package menu;

import java.util.List;
import menu.domain.CategoryRecommendation;
import menu.domain.Coach;
import menu.initializer.FoodInitializer;
import menu.input.InputView;
import menu.output.ResultOutput;
import menu.recommendator.MenuRecommender;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        FoodInitializer.initializeFood();
        run();
    }

    private static void run() {
        List<Coach> coaches = InputView.readCoachNames();
        InputView.readInedibleFoodsOfCoaches(coaches);
        CategoryRecommendation.recommendCategories();
        MenuRecommender.recommendMenuOfCoaches(coaches);
        ResultOutput.printResult(coaches);
    }
}
