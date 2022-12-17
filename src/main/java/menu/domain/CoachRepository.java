package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class CoachRepository {
    // 맵 구조를 가져가야할까?
    private List<Coach> coaches = new ArrayList<>();

    private static final CoachRepository instance = new CoachRepository();

    public static CoachRepository getInstance() {
        return instance;
    }

    public Coach save(Coach coach){
        coaches.add(coach);
        return coach;
    }

    public List<Coach> findALl(){
        return new ArrayList<>(coaches);
    }

}
