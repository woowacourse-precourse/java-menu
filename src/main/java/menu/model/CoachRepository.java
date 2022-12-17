package menu.model;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CoachRepository {

    private static final List<Coach> coaches = new ArrayList<>();

    public static List<Coach> coaches() {
        return Collections.unmodifiableList(coaches);
    }

    public static void addCoach(Coach coach) {
        coaches.add(coach);
    }

    //TODO: 지워야 함
    public static void print() {
        for (Coach coach : coaches) {
            System.out.println(coach.getName() + ": " + coach.getHateFoods());
        }
    }
}
