package menu.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static menu.util.ErrorMessage.COACH_SIZE_OVER_ERROR_MESSAGE;

public class CoachGroup {

    private static final String SEPARATOR = ",";
    private final List<Coach> coaches;

    public CoachGroup(String names){
        List<String> parseNames = parseName(names);
        validateLength(parseNames);
        coaches = makeCoachGroup(parseNames);
    }

    public List<String> parseName(String names){
        String[] split = names.split(SEPARATOR);
        return Arrays.stream(split).map(s->s.trim()).collect(Collectors.toList());
    }

    public List<Coach> makeCoachGroup(List<String> names){
        return names.stream().map(Coach::new).collect(Collectors.toList());
    }

    public void validateLength(List<String> names){
        if(isCorrectSize(names)){
            return;
        }
        throw new IllegalArgumentException(COACH_SIZE_OVER_ERROR_MESSAGE.getMessage());
    }

    private static boolean isCorrectSize(List<String> names) {
        return names.size() >= 2 && names.size() <= 5;
    }


}
