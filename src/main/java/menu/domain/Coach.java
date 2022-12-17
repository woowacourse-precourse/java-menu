package menu.domain;

import java.util.List;
import java.util.Map;

public class Coach {

    private List<String> coach;
    private Map<String, List<String>> coaches;

    public Coach(Map<String, List<String>> coaches) {
        this.coaches = coaches;
    }

    public Map<String, List<String>> getCoaches() {
        return coaches;
    }
}
