package menu.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BannedFoods {
    private List<String> bannedFoods;

    public BannedFoods() {
        bannedFoods = new ArrayList<>();
    }

    public void addBannedFood(String food) {
        this.bannedFoods.add(food);
    }

    public List<String> getBannedFoods() {
        return bannedFoods;
    }

    public void addBannedFoods(String bannedFoodsInput) {
        Arrays.stream(bannedFoodsInput.split(","))
                .forEach(name -> addBannedFood(name));
    }
}
