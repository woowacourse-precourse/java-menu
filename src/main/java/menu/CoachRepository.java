package menu;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoachRepository {

    /**
     * Coach Repository 에서 Coach 들을 가지고 있을 것임
     * Coach 는 각각 HashMap<String, Coach> 로 가지고 있을 것임
     * 그리고 CoachRepository 를 View 는 사용할 수 있기 때문에, CoachRepository 를 입력으로 받아서 순서대로 진행할 것임
     * Coach Name 을 출력하고 입력 받으면서 쨋든 Controller 로 부터 View 의 입력을 받아서 Coach 들을 순서대로 만들어낼 것임
     */
    private Map<String, Coach> coaches;

    public CoachRepository() {
        this.coaches = new HashMap<>();
    }

    public void generateCoaches(List<String> nameOfCoaches) {
        for (String name : nameOfCoaches) {
            coaches.put(name, new Coach(name));
        }
    }
}
