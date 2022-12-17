package menu.validator;

import java.util.List;
import java.util.stream.Collectors;
import menu.domain.Coach;
import menu.exception.CoachDuplicateException;

public class CoachDuplicateValidator {
    public void validate(List<Coach> coaches) {
        if (coaches.stream().distinct().collect(Collectors.toList()).size() != coaches.size()) {
            throw new CoachDuplicateException();
        }
    }
}
