package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Crews {
    private List<Crew> crews;

    public Crews() {
        crews = new ArrayList<>();
    }

    public void addCrew(Crew crew) {
        this.crews.add(crew);
    }
}
