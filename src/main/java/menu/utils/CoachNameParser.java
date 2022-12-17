package menu.utils;

import menu.exception.CoachCountException;
import menu.exception.CoachNameLengthException;
import menu.exception.CoachOverlappedException;
import menu.exception.NameIsBlankException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class CoachNameParser {
    private static final int MAX_NAME_LENGTH = 4;
    private static final int MIN_NAME_LENGTH = 2;
    private static final int MAX_COACH_COUNT = 5;
    private static final int MIN_COACH_COUNT = 2;
    private static final String NAME_DELIMITER = ",";

    private static boolean isInvalidNameLength(String name) {
        int nameLength = name.length();
        return nameLength < MIN_NAME_LENGTH || nameLength > MAX_NAME_LENGTH;
    }

    private static void validate(String name) {
        if (isInvalidNameLength(name)) {
            throw new CoachNameLengthException();
        }
        if (name.isBlank()) {
            throw new NameIsBlankException();
        }
    }

    private static boolean isInvalidCoachCount(int count) {
        return count < MIN_COACH_COUNT || count > MAX_COACH_COUNT;
    }

    private static boolean hasOverlappedNames(List<String> names) {
        int count = names.size();

        return new HashSet<>(names).size() != count;
    }

    private static void validateNames(List<String> names) {
        if (hasOverlappedNames(names)) {
            throw new CoachOverlappedException();
        }
        if (isInvalidCoachCount(names.size())) {
            throw new CoachCountException();
        }
    }

    public static List<String> parseName(String input) {
        List<String> names = new ArrayList<>();
        for (String name: input.split(NAME_DELIMITER)) {
            validate(name);
            names.add(name);
        }
        validateNames(names);

        return names;
    }
}
