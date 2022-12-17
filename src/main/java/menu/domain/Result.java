package menu.domain;

import java.util.List;

public class Result {
    private String name;
    private List<String> foods;

    public Result(String name, List<String> foods) {
        this.name = name;
        this.foods = foods;
    }

    public String getName() {
        return this.name;
    }

    public List<String> getFoods() {
        return this.foods;
    }
}
