package menu.domain;

import java.util.List;

public class Couch {
    private String name;
    private List<Food> denied;

    private Couch(String name) {
        this.name = name;
    }

    public static Couch from(String name) {
        return new Couch(name);
    }
}
