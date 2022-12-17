package menu.repository;

import menu.domain.Coach;
import menu.repository.constant.SizeLimit;

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

    public boolean isValidSize(int size) {
        return size >= SizeLimit.COACH_MIN_SIZE.getSize()
                && size <= SizeLimit.COACH_MAX_SIZE.getSize();
    }

    public boolean isValidCoach(String coachName) {
        return coaches.stream().anyMatch(coach -> coachName.equals(coach.getName()));
    }
}
