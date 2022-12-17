package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class MenuMaker {

    public List<String> nameDivision(String coach) {
        List<String> coaches = new ArrayList<>();
        for (String person : coach.split(",")) {
            coaches.add(person);
        }
        return coaches;
    }

    public List<String> menuDivision(String menu) {
        List<String> menuContainer = new ArrayList<>();
        for (String food : menu.split(",")) {
            menuContainer.add(food);
        }
        return menuContainer;
    }
}
