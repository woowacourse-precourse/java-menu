package menu.domain.coach;

import java.util.List;

public class Coach {
    private String name;
    private List<String> foods;

    Coach(String name) {
        this.name = name;
    }
    public static Coach of(String userName) {
        return new Coach(userName);
    }

    public String getName() {
        return name;
    }

    public List<String> getFoods() {
        return foods;
    }

    public void initFoods(List<String> foods) {
        this.foods = foods;
    }


}
