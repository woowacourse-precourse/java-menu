package menu;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoachHates {

    private final Map<String, List<String>> coachHateMap;

    public CoachHates() {
        this.coachHateMap = new HashMap<>();
    }

    public void updateHateMap(String coachName, List<String> foods) {
        coachHateMap.put(coachName, foods);
    }

    public Map<String, List<String>> getCoachHateMap(){
        return this.coachHateMap;
    }

}
