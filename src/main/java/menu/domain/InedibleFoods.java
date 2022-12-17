package menu.domain;

import java.util.ArrayList;
import java.util.List;
public class InedibleFoods {
    private List<String> bannedFoods;

    public InedibleFoods() {
        bannedFoods = new ArrayList<>();
    }

    public void addBannedFood(String food) {
        this.bannedFoods.add(food);
    }

    public List<String> getBannedFoods() {
        return bannedFoods;
    }
}
