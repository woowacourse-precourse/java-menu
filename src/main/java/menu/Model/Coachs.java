package menu.Model;

import java.util.List;

public class Coachs {
    List<Coach> coachs;

    public Coachs(String input) {
        String[] names = input.split(",");
        for (String name : names) {
            Coach coach = new Coach(name);
            this.coachs.add(coach);
        }
    }

    public List<Coach> getCoachs() {
        return this.coachs;
    }
}
