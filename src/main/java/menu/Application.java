package menu;

import java.util.List;
import menu.domain.Coach;
import menu.initializer.FoodInitializer;
import menu.input.InputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        FoodInitializer.initializeFood();
        run();
    }

    private static void run() {
        List<Coach> coaches = InputView.readCoachNames();
        InputView.readInedibleFoodsOfCoaches(coaches);
    }
}
