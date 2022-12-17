package menu.view;

import menu.model.Category;

import java.util.List;
import java.util.Map;

public class ConsoleUtil {

    static InputView inputView;

    static {
        inputView = new InputView();
    }

    public static List<String> inputCoachName() {
        return inputView.readCoachName();
    }

    public static Map<String, List<String>> inputExceptedFood(final List<String> coachNames) {
        return inputView.readExceptedFood(coachNames);
    }

    public static void outputGameResult(final Category category,
                                        final Map<String, List<String>> menu) {

        OutputView.printDay();
        OutputView.printCategory(category);
        OutputView.printMenu(menu);
    }
}
