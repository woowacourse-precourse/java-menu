package menu.domain;

import java.util.List;

public class Coach {

    private List<String> coaches;

    public Coach(List<String> coaches) {
        this.coaches = coaches;
    }

    public List<String> getCoaches() {
        return coaches;
    }
}
