package menu.model;

import java.util.List;

public class Coach {
    private String name;
    private List<String> allergy;

    public Coach(String name, List<String> allergy) {
        this.name = name;
        this.allergy = allergy;
    }
}
