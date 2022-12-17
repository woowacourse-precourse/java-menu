package menu;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CoachRepository {

    private final Map<String, Coach> coaches;

    public CoachRepository() {
        this.coaches = new LinkedHashMap<>();
    }

    public void generateCoaches(List<String> nameOfCoaches) {
        for (String name : nameOfCoaches) {
            coaches.put(name, new Coach(name));
        }
    }

    public void foodRecommendForDay(Category category, RecommendMachine recommendMachine) { // 모든 날의 음식을 추천
        for (Coach coach : coaches.values()) {
            recommendMachine.recommend(category, coach); // 각각 recommend 해주면 됨 이때부터는
        }
    }

    public List<Coach> getCoaches() {
        return new ArrayList<>(coaches.values());
    }
}
