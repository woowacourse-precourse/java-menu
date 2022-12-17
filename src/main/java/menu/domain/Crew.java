package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Crew {
    private String name;
    private List<String> foods;

    public Crew(String name) {
        this.name = name;
        foods = new ArrayList<>();
    }
}
