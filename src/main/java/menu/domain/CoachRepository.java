package menu.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CoachRepository {
    private static final List<Coach> coaches = new ArrayList<>();
    public static void saveAll(List<Coach> coachesToSave) {
        Validator.validateOnSaving(coachesToSave);
        coaches.addAll(coachesToSave);
    }

    public static List<Coach> findAll() {
        return Collections.unmodifiableList(coaches);
    }

    private static class Validator {

        public static final String INVALID_COACH_SIZE = "코치는 최소 2명, 최대 5명까지 식사를 함께 한다.";
        public static final String DUPLICATION_COACH_NAME = "코치 이름은 중복되지 않아야 함";

        public static void validateOnSaving(List<Coach> coachesToSave) {
            isCoachesValidSize(coachesToSave);
            isCoachNameDuplicating(coachesToSave);
        }

        private static void isCoachNameDuplicating(List<Coach> coachesToSave) {
            for (Coach coach : coachesToSave) {
                if (Collections.frequency(coachesToSave, coach) != 1) {
                    throw new IllegalArgumentException(DUPLICATION_COACH_NAME);
                }
            }
        }

        private static void isCoachesValidSize(List<Coach> coachesToSave) {
            if (coachesToSave.size() < Coach.minSize || Coach.maxSize < coachesToSave.size()) {
                throw new IllegalArgumentException(INVALID_COACH_SIZE);
            }
        }
    }
}
