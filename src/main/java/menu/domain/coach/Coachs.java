package menu.domain.coach;

import java.util.ArrayList;
import java.util.List;

public class Coachs {
    private List<Coach> coachs;

    Coachs(List<Coach> coachs) {
        this.coachs = coachs;
    }

    public static Coachs of(List<String> userList) {
        List<Coach> coaches = new ArrayList<>();
        for (String user : userList) {
            coaches.add(Coach.of(user));
        }
        return new Coachs(coaches);
    }

    public List<Coach> getCoachs() {
        return coachs;
    }
}
