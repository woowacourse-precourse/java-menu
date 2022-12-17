package coach;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Managecoach {
    private List<Coach> coachList;

    public Managecoach(List<String> coachNameList) {
        this.coachList = new ArrayList<>();
        for (String coachName : coachNameList) {
            this.coachList.add(new Coach(coachName));
        }
    }

    public List<Coach> getCoachList() {
        return this.coachList;
    }
}
