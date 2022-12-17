package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class CoachRepository {

    private List<Coach> coachList = new ArrayList<>();

    public CoachRepository(List<Coach> coaches) {
        this.coachList = coaches;
    }

    public List<Coach> getCoachList() {
        return coachList;
    }
}
