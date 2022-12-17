package menu.repository;

import java.util.ArrayList;
import java.util.List;
import menu.domain.Coach;
import menu.domain.Coaches;
import menu.message.ErrorMessage;

public class CoachesRepository {
    public static final int COACHES_INDEX = 0;
    private static final CoachesRepository instance = new CoachesRepository();
    private static final List<Coaches> store = new ArrayList<>();

    private CoachesRepository() {
    }


    public static Coaches save(final List<Coach> coaches) {
        delete();
        store.add(new Coaches(coaches));
        return find();
    }

    private static Coaches find() {
        return store.get(COACHES_INDEX);
    }

    private static void delete() {
        store.clear();
    }

    public static Coach findByName(final String coachName) {
        return find()
                .getCoachList()
                .stream()
                .filter(coach -> coach.containsName(coachName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.NOT_EXISTS_COACH_NAME));

    }
}
