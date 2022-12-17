package menu.repository;

import menu.domain.Coach;

import java.util.ArrayList;
import java.util.List;

public class CoachRepository {
    private static final CoachRepository instance = new CoachRepository();
    private static final List<Coach> coachs = new ArrayList<>();

    private CoachRepository() {
    }

    public static CoachRepository getInstance() {
        return instance;
    }

    public static List<Coach> getCoachs(){
        return coachs;
    }

    public static void saveCoach(Coach coach){
        coachs.add(coach);
    }

}
