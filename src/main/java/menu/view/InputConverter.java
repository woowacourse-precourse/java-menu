package menu.view;

import java.util.List;
import java.util.stream.Collectors;
import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Menu;

public class InputConverter {

    public static List<Coach> convertToCoach(List<String> coachNames) {
        return coachNames.stream().map(Coach::new).collect(Collectors.toList());
    }

    public static List<Menu> convertToMenu(List<String> menuNames) {
        return menuNames.stream().map(Category::findMenuByName).collect(Collectors.toList());
    }
}
