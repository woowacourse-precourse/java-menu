package menu.model.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Coach {
    private String name;
    private List<Food> cannotEatFoods;
    private List<String> lunchMenu = new ArrayList<>();

    public Coach(String name, List<Food> cannotEatFoods) {
        this.name = name;
        this.cannotEatFoods = cannotEatFoods;
    }

    public List<String> getCannotEatFoods() {
        return cannotEatFoods.stream()
                .map(Food::getName)
                .collect(Collectors.toList());
    }

    public String getName() {
        return name;
    }

    public void setLunchMenu(String menu) {
        this.lunchMenu.add(menu);
    }

    public List<String> getLunchMenu() {
        return lunchMenu;
    }

    public List<String> makeLunchMenu() {
        List<String> lunchMenuBefore = getLunchMenu();
        List<String> lunchNew = new ArrayList<>(lunchMenuBefore);
        lunchNew.add(lunchMenuBefore.get(0));
        lunchNew.remove(0);
        return lunchNew;
    }
}
