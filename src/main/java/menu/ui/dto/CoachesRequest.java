package menu.ui.dto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import menu.common.ErrorMessage;
import menu.domain.coach.Coach;
import menu.domain.coach.Coaches;

public class CoachesRequest {
    private static final String LIST_DIAMETER = ",";
    private final List<String> coaches;

    private CoachesRequest(List<String> coaches) {
        this.coaches = coaches;
    }

    public static CoachesRequest from(String userInput) {
        validate(userInput);
        List<String> coaches = Arrays.stream(userInput.split(LIST_DIAMETER))
                .map(String::trim)
                .collect(Collectors.toList());
        return new CoachesRequest(coaches);
    }

    private static void validate(String userInput) {
        String[] coaches = userInput.split(LIST_DIAMETER);
        validateSize(coaches);
        validateDuplication(coaches);
    }

    private static void validateDuplication(String[] coaches) {
        long distinctSize = Arrays.stream(coaches)
                .map(String::trim)
                .distinct()
                .count();

        if (distinctSize != coaches.length) {
            throw new IllegalArgumentException(ErrorMessage.COACH_NAME_DUPLICATED);
        }
    }

    private static void validateSize(String[] coaches) {
        if (coaches.length < 2) {
            throw new IllegalArgumentException(ErrorMessage.COACHES_UNDER_MIN_SIZE);
        }

        if (coaches.length > 5) {
            throw new IllegalArgumentException(ErrorMessage.COACHES_OVER_MAX_SIZE);
        }
    }

    public List<String> getCoaches() {
        return coaches;
    }

    public Coaches toCoaches() {
        List<Coach> coaches = this.coaches.stream()
                .map(Coach::fromName)
                .collect(Collectors.toList());

        return Coaches.of(coaches);
    }
}
