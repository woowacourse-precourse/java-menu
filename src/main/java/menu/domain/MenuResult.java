package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class MenuResult {

    private final List<Category> categorys;
    private final Coaches coaches;

    public MenuResult(List<Category> categorys, Coaches coaches) {
        this.categorys = new ArrayList<>();
        this.coaches = coaches;
    }

    public List<Category> getCategory() {
        return categorys;
    }

    public Coaches getCoaches() {
        return coaches;
    }
}
