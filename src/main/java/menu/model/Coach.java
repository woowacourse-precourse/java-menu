package menu.model;

import java.util.HashSet;

public class Coach {
    private String name;
    private HashSet<String> allergy;

    public Coach(String name, HashSet<String> allergy) {
        this.name = name;
        this.allergy = allergy;
    }

    public String getName() {
        return name;
    }

    public void addAllergy(String allegeMenu) {
        allergy.add(allegeMenu);
    }
}
