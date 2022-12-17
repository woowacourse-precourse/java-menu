package menu.repository;

import menu.domain.Coach;

import java.util.ArrayList;
import java.util.List;

public class CoachRepository {
    private static class InstanceHolder {
        private static final CoachRepository INSTANCE = new CoachRepository();
    }

    private List<Coach> coaches;

    private CoachRepository() {
        coaches = new ArrayList<>();
    }

    public static CoachRepository getInstance() {
        return CoachRepository.InstanceHolder.INSTANCE;
    }
}
