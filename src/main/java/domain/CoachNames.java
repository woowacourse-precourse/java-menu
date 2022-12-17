package domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import util.Validator;

public class CoachNames {
    public final List<String> coachNames;

    public CoachNames(String names) {
        coachNames = Arrays.stream(names.split(",")).collect(Collectors.toList());
        Validator.validateCoachName(coachNames);
    }

    public List<String> getCoachNames() {
        return coachNames;
    }
}
