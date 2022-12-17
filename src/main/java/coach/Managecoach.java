package coach;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Managecoach {
    private List<Coach> CoachList;

    public Managecoach(List<String> coachNameList) {
        this.CoachList = new ArrayList<>();
        for (String coachName : coachNameList) {
            Coach coach = new Coach(coachName);
            this.CoachList.add(coach);
        }
    }

    public List<Coach> getCoachList() {
        return this.CoachList;
    }
}
