package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Coach {

    private String name;
    private List<String> dislikeFood;

    public Coach(String name) {
        this.name = name;
        this.dislikeFood = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<String> getDislikeFood() {
        return dislikeFood;
    }
}
