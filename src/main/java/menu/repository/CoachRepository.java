package menu.repository;

import menu.domain.Coach;
import menu.repository.constant.SizeLimit;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public void addCoach(String coachName) {
        coaches.add(new Coach(coachName));
    }

    public boolean isValidSize(int size) {
        return size >= SizeLimit.COACH_MIN_SIZE.getSize()
                && size <= SizeLimit.COACH_MAX_SIZE.getSize();
    }

    public boolean isValidCoach(String coachName) {
        return coaches.stream().anyMatch(coach -> coachName.equals(coach.getName()));
    }

    public Coach findCoachByName(String coachName) {
        return coaches.stream().filter(coach -> coachName.equals(coach.getName()))
                .findAny()
                .orElseThrow();
    }

    public List<String> findAllCoach() {
        return coaches.stream().map(Coach::getName)
                .collect(Collectors.toUnmodifiableList());
    }
}
