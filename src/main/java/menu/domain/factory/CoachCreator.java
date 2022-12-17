package menu.domain.factory;

import menu.domain.coach.Coach;
import menu.validator.domain.InputCoachNamesValidator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CoachCreator {
    public static List<Coach> from(String coachNames) {
        InputCoachNamesValidator.validate(coachNames);
        return splitCoachNames(coachNames).stream()
                .map(Coach::new)
                .collect(Collectors.toUnmodifiableList());
    }
    
    private static List<String> splitCoachNames(String coachNames) {
        return Arrays.stream(coachNames.split(","))
                .collect(Collectors.toUnmodifiableList());
    }
}
