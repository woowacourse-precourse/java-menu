package menu;


import java.util.ArrayList;
import java.util.List;

public class Coach {
    private final String name;
    private List<String> hateFoods = new ArrayList<>();

    public Coach(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void addHateFoodList(List<String> foodNames) {
        this.hateFoods.addAll(foodNames);
    }
}
