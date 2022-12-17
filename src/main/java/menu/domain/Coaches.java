package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Coaches {

    private List<Coach> coaches;
    private List<List<String>> menu;

    public Coaches() {
        this.coaches = new ArrayList<>();
        this.menu = new ArrayList<>();
    }

    public void setCoaches(List<Coach> coaches) {
        this.coaches = coaches;
    }
}
