package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class BannedFoods {
    private List<String> bannedFoods;

    public BannedFoods() {
        bannedFoods = new ArrayList<>();
    }

    public void addBannedFood(String food) {
        this.bannedFoods.add(food);
    }
}
