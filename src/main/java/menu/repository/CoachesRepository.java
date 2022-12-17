package menu.repository;

import java.util.ArrayList;
import java.util.List;
import menu.domain.Coach;
import menu.domain.Coaches;

public class CoachesRepository {
    private static final CoachesRepository instance = new CoachesRepository();
    private static final List<Coaches> store = new ArrayList<>();

    private CoachesRepository() {
    }


    public static void save(final List<Coach> coaches) {
        store.add(new Coaches(coaches));
    }
}
