package menu.domain;

import java.util.List;

public class DislikeFood {

    private final List<Menu> dislikeFoods;

    public DislikeFood(List<Menu> dislikeFoods) {
        this.dislikeFoods = dislikeFoods;
    }

    public List<Menu> getDislikeFoods() {
        return dislikeFoods;
    }
}
