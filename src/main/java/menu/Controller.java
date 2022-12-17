package menu;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    private static final int DAYS = 5;
    private static final int EXIT = 0;
    private static final String CATEGORY = "카테고리";
    List<Coach> coaches = new ArrayList<>();
    MenuSelector menuSelector = new MenuSelector();


    public void initGame() {
        System.out.println(Output.INIT);
        String[] names = ExceptionHandler.input(Input::inputName);
        for (String name : names) {
            List<String> hates = Input.inputHate(name);
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
        System.out.println(Output.DAYS);
        System.out.println(ResultView.print(CATEGORY, menuSelector.getCategoryRepository()));
        for (Coach coach : coaches) {
            System.out.println(ResultView.print(coach.getName(), coach.getEatenFood()));
        }
        System.out.println(Output.END);
    }
}
