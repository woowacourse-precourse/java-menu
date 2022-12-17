package menu.domain.coach;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoachRepository {
    private static List<Coach> coaches = new ArrayList<>();

    private static final CoachRepository instance = new CoachRepository();

    public static CoachRepository getInstance() {
        return instance;
    }

    public Coach save(Coach coach){
        coaches.add(coach);
        return coach;
    }

    public List<Coach> findAll(){
        return new ArrayList<>(coaches);
    }

    // OutputView에 최대한 정보를 적게 넘겨주기 위한 메소드
    public Map<String, List<String>> getAteMenuNamesByCoachName(){
        Map<String, List<String>> allStatus = new HashMap<>();
        for (Coach coach : coaches) {
            allStatus.put(coach.getName(), coach.getAteMenuNames());
        }
        return allStatus;
    }

}
