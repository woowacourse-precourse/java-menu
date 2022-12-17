package menu;

import java.util.ArrayList;
import java.util.List;

public class Coaches {

    private final List<Coach> coaches;

    public Coaches(List<String> coaches) {
        validCoaches(coaches);
        this.coaches = listToCoaches(coaches);
    }

    public List<Coach> getCoaches() {
        return this.coaches;
    }

    private void validCoaches(List<String> coaches) {
        if (coaches.size() < 2 || coaches.size() > 5) {
            throw new IllegalArgumentException("코치 맴버는 2명 ~ 5명을 입력해야 합니다.");
        }
    }

    private List<Coach> listToCoaches(List<String> coaches) {
        List<Coach> tmpCoaches = new ArrayList<>();
        for (String name : coaches) {
            tmpCoaches.add(new Coach(name));
        }
        return tmpCoaches;
    }
}
