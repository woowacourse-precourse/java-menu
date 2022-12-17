package menu.Domain;

import java.util.List;

public class Coach {
    private String name;
    private List<String> allergic;

    public Coach(String name, List<String> allergic) {
        this.name = name;
        this.allergic = allergic;
    }
}
