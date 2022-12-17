package menu.validator.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputCoachNamesValidator {
    public static void validate(String coachName) {
        List<String> strings = splitCoachNames(coachName);
        validateCountOfCoach(strings);
    }
    
    private static List<String> splitCoachNames(String coachName) {
        return Arrays.stream(coachName.split(","))
                .collect(Collectors.toUnmodifiableList());
    }
    
    private static void validateCountOfCoach(List<String> coachNames) {
        if (isCountOfCoachOutOgRange(coachNames)) {
            throw new IllegalArgumentException("[ERROR] 코치 생성 범위는 2~5명 입니다.");
        }
    }
    
    private static boolean isCountOfCoachOutOgRange(List<String> coachNames) {
        return coachNames.size() < 2 || coachNames.size() > 5;
    }
}
