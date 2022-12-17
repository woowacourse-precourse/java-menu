package domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import util.Validator;

public class CoachNames {
    private static final String COMMA = ",";
    public final List<String> coachNames;

    public CoachNames(String names) {
        coachNames = Arrays.stream(names.split(COMMA)).collect(Collectors.toList());
        Validator.validateCoach(coachNames);
    }

    public List<String> getCoachNames() {
        return coachNames;
    }
}
