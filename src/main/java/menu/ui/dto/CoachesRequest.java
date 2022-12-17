package menu.ui.dto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import menu.domain.coach.Coach;
import menu.domain.coach.Coaches;

public class CoachesRequest {
    private final List<String> coaches;

    private CoachesRequest(List<String> coaches) {
        this.coaches = coaches;
    }

    public static CoachesRequest from(String userInput) {
        validate(userInput);
        List<String> coaches = Arrays.stream(userInput.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
        return new CoachesRequest(coaches);
    }

    private static void validate(String userInput) {
        String[] coaches = userInput.split(",");
        validateSize(coaches);
        validateDuplication(coaches);
    }

    private static void validateDuplication(String[] coaches) {
        long distinctSize = Arrays.stream(coaches)
                .map(String::trim)
                .distinct()
                .count();

        if (distinctSize != coaches.length) {
            throw new IllegalArgumentException("[ERROR] 동일한 코치를 입력 할 수 없습니다.");
        }
    }

    private static void validateSize(String[] coaches) {
        if (coaches.length < 2) {
            throw new IllegalArgumentException("[ERROR] 코치는 최소 2명 이상 입력해야 합니다.");
        }

        if (coaches.length > 5) {
            throw new IllegalArgumentException("[ERROR] 코치는 최대 5명 까지 입력 가능 합니다.");
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
