package menu.utils.validator;

import java.util.Arrays;
import menu.utils.constants.Common;
import menu.utils.error.exception.DuplicatedCoachNameException;
import menu.utils.error.exception.InvalidCoachNameLength;
import menu.utils.error.exception.InvalidInputArgument;
import menu.utils.error.exception.InvalidNumberOfCoachException;

public class CoachNameInputValidator implements InputValidator {

    @Override
    public void validate(String input) {
        String[] names = input.split(DELIMITER);
        if (isNotValidNumberOfCoach(names)) {
            throw new InvalidNumberOfCoachException();
        }
        if (isDuplicatedCoachName(names)) {
            throw new DuplicatedCoachNameException();
        }
        if (invalidArgument(input, names)) {
            throw new InvalidInputArgument();
        }
        if (invalidCoachNameLength(names)) {
            throw new InvalidCoachNameLength();
        }
    }

    private boolean invalidArgument(String input, String[] names) {
        return input.chars().filter(c -> c == DELIMITER_CHAR).count() + 1 != names.length;
    }

    private boolean isDuplicatedCoachName(String[] names) {
        return Arrays.stream(names).distinct().count() != names.length;
    }

    private boolean isNotValidNumberOfCoach(String[] names) {
        return !(names.length >= Common.MIN_COACH_NUMBER.getNumber()
                && names.length <= Common.MAX_COACH_NUMBER.getNumber());
    }

    private boolean invalidCoachNameLength(String[] names) {
        return Arrays.stream(names)
                .anyMatch(name -> !(name.length() >= Common.MIN_COACH_NAME_LENGTH.getNumber()
                        && name.length() <= Common.MAX_COACH_NAME_LENGTH.getNumber()));
    }
}
