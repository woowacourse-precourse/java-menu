package menu.utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import menu.domain.Coach;

public class CoachesConverter {

    private CoachesConverter() {
    }

    public static List<Coach> convert(String input) {
        List<Coach> coaches = generateCoaches(input);
        validate(coaches);
        return coaches;
    }

    private static List<Coach> generateCoaches(String input) {
        return Arrays.stream(input.split(","))
                .map(s -> s.trim())
                .map(Coach::new)
                .collect(Collectors.toList());
    }

    private static void validate(List<Coach> coaches) {
        validateSize(coaches);
        validateDuplication(coaches);
    }

    private static void validateSize(List<Coach> coaches) {
        if (coaches.size() < 2 || coaches.size() > 5) {
            throw new IllegalArgumentException("코치는 최소 2명, 최대 5명까지 식사를 함께 한다.");
        }
    }

    private static void validateDuplication(List<Coach> coaches) {
        Set<Coach> uniqueCoaches = new HashSet<>(coaches);

        if (uniqueCoaches.size() != coaches.size()) {
            throw new IllegalArgumentException("중복되는 코치가 존재합니다.");
        }
    }
}
