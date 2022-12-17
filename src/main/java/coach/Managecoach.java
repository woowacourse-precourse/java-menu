package coach;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Managecoach {
    private List<Coach> coachList;

    public Managecoach(List<String> coachNameList) {
        this.coachList = new ArrayList<>();
        for (String coachName : coachNameList) {
            checkSameName(coachName);
            Coach coach = new Coach(coachName);
            this.coachList.add(coach);
        }
    }

    public List<Coach> getCoachList() {
        return this.coachList;
    }

    public void checkSameName(String coachName) {
        for (Coach coach : coachList) {
            if (coach.getName().equals(coachName))
                throw new IllegalArgumentException("동일한 코치를 입력했습니다.");
        }
    }
}
