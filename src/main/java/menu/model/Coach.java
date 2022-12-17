package menu.model;

import java.util.List;

public class Coach {
    private String name;
    private List<String> cantEats;

    public Coach(String name,List<String> cantEats){
        this.name=name;
        this.cantEats=cantEats;
    }

    public String getName() {
        return name;
    }

    public List<String> getCantEats() {
        return cantEats;
    }
}
