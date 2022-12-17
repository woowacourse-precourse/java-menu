package menu.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CoachRepository {
    private final List<Coach> coaches = new ArrayList<>();
    private final int minCoachCount = 2;
    private final int maxCoachCount = 5;
    public static final String SEPARATOR = ",";
    public final String coachInputErrorMsg = "[ERROR] 코치이름을 ,로 구분하여 정확하게 입력해주세요.";
    public final String coachCountErrorMsg = "[ERROR] 코치는 " + minCoachCount + "~" + maxCoachCount + "명만 입력 가능합니다.";


    public CoachRepository(String userInputCoaches) {
        validateNotNull(userInputCoaches);
        validateContainComma(userInputCoaches);
        addCoach(userInputCoaches);
    }

    private void validateNotNull(String userInputCoaches) {
        if (userInputCoaches == null || userInputCoaches.trim().length() == 0)
            throw new IllegalArgumentException(coachInputErrorMsg);
    }

    private void validateContainComma(String userInputCoaches) {
        if (!userInputCoaches.contains(SEPARATOR))
            throw new IllegalArgumentException(coachInputErrorMsg);
    }

    private void addCoach(String userInputCoaches) {
        List<String> inputCoaches = List.of(userInputCoaches.split(SEPARATOR));
        if (inputCoaches.size() < minCoachCount || inputCoaches.size() > maxCoachCount) {
            throw new IllegalArgumentException(coachCountErrorMsg);
        }
        for (String inputCoach : inputCoaches) {
            coaches.add(new Coach(inputCoach.trim()));
        }
    }

    public List<Coach> coaches() {
        return Collections.unmodifiableList(coaches);
    }

}
