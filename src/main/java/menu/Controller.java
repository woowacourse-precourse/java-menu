package menu;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    List<Coach> coaches = new ArrayList<>();
    MenuSelector menuSelector = new MenuSelector();

    private static final int DAYS = 5;
    private static final int EXIT = 0;

    public void initGame() {
        System.out.println(Output.INIT);
        System.out.println(Output.INPUT_COACH);
        String[] names = Input.inputName();
        for (String name : names) {
            System.out.printf((Output.INPUT_HATE) + "%n", name);
            List<String> hates = Input.inputHate();
            coaches.add(new Coach(name, hates));
        }
    }

    public int calculateMenu(int count) {
        if (count == DAYS) {
            return EXIT;
        }
        String category = menuSelector.pickCategory();
        List<String> menus = Dish.pickCategory(category);
        for (Coach coach : coaches) {
            coach.pickFood(menus);
        }
        return calculateMenu(count + 1);
    }

    public void printResult() {
        System.out.println(Output.PRINT_RESULT);
        System.out.println(ResultView.print("카테고리", menuSelector.getCategoryRepository()));
        for (Coach coach : coaches) {
            System.out.println(ResultView.print(coach.getName(), coach.getEatenFood()));
        }
        System.out.println(Output.END);
    }
}
