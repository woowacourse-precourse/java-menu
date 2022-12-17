package menu.domain;

import java.util.List;

public class CoachList {

    private final List<Coach> coachList;

    private CoachList(List<Coach> coachList) {
        this.coachList = coachList;
    }

    public static CoachList from(List<Coach> coachList) {
        return new CoachList(coachList);
    }

    public List<Coach> getCoachList() {
        return coachList;
    }

    public int getCoachCount() {
        return coachList.size();
    }

    @Override
    public String toString() {
        return coachList.toString();
    }
}
