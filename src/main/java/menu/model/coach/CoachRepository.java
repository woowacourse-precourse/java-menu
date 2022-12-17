package menu.model.coach;

import menu.ErrorConstants;

import java.util.List;

public class CoachRepository {

    private List<Coach> coaches;

    public void saveCoach(Coach coach) {
        coaches.add(coach);
    }

    public Coach findByCoachName(String coachName) {
        return coaches.stream()
                .filter(coach -> coach.isEqualCoach(coachName))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(
                        ErrorConstants.ERROR_PREFIX + "이름에 해당하는 코치가 존재하지 않습니다."));
    }
}
