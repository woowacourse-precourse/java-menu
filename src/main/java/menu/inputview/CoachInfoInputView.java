package menu.inputview;

import menu.domain.Coach;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CoachInfoInputView extends AbstractInputView {

    public static List<Coach> getCoaches() {
        String coachNamesInput = readInput();
        return Converter.toCoaches(coachNamesInput);
    }

    private static class Converter {

        public static final String COMMA = ",";

        public static List<Coach> toCoaches(String coachNamesInput) {
            String[] coachNames = coachNamesInput.split(COMMA);
            return Arrays.stream(coachNames)
                    .map(Coach::new)
                    .collect(Collectors.toList());
        }
    }
}
