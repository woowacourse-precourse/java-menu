package menu.controller;

import java.util.ArrayList;
import java.util.List;

public class Coaches {

    private final List<Coach> coaches;

    public Coaches(String coaches) {
        this.coaches = new ArrayList<>();
        splitCoaches(coaches);
    }

    private void splitCoaches(String coaches) {
        String[] names = coaches.split(",");
        for(String name: names){
            this.coaches.add(new Coach(name));
        }
    }

    public List<Coach> getCoaches() {
        return coaches;
    }

}
