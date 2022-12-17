package coach;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private String name;
    private List<Integer> category;
    private List<String> hateFood;

    public Coach(String coachName) {
        this.name = coachName;
        this.category = List.of(0, 0, 0, 0, 0);
        this.hateFood = new ArrayList<>();
    }

}
