package menu.Domain;

import java.util.HashMap;
import java.util.List;

public class Coach {
    private String name;
    private List<String> allergic;
    private HashMap<String, List<String>> database;

    public Coach(String name, List<String> allergic, HashMap<String, List<String>> database) {
        this.name = name;
        this.allergic = allergic;
        this.database = database;
    }

}
