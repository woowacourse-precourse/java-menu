package menu.domain;

import menu.constant.ExceptionConstants;
import menu.constant.MenuConstants;
import menu.util.Validator;

import java.util.ArrayList;
import java.util.List;

public class CoachList {
    private final List<String> coachNames = new ArrayList<>();
    private final List<Coach> coachList = new ArrayList<>();

    public CoachList(String coachNames) {
        List<String> splittedCoachNames = List.of(coachNames.split(MenuConstants.INPUT_DELIMITER));
        validateCoachNames(splittedCoachNames);
        this.coachNames.addAll(splittedCoachNames);
    }

    private void validateCoachNames(List<String> splittedCoachNames) {
        Validator.validateLowerBound(splittedCoachNames.size(),
                MenuConstants.MINIMUM_NUMBER_OF_COACHES,
                ExceptionConstants.NOT_ENOUGH_COACH);

        Validator.validateUpperBound(splittedCoachNames.size(),
                MenuConstants.MAXIMUM_NUMBER_OF_COACHES,
                ExceptionConstants.TOO_MANY_COACHES);

        Validator.validateDuplication(splittedCoachNames);
        splittedCoachNames.stream()
                .map(String::length)
                .forEach(this::validateCoachNameLength);
    }

    private void validateCoachNameLength(int coachNameLength) {
        Validator.validateLowerBound(coachNameLength,
                MenuConstants.MINIMUM_COACH_NAME_LENGTH,
                ExceptionConstants.TOO_SHORT_NAME_LENGTH);

        Validator.validateUpperBound(coachNameLength,
                MenuConstants.MAXIMUM_COACH_NAME_LENGTH,
                ExceptionConstants.TOO_LONG_NAME_LENGTH);
    }

    public void add(String name, String inedibleMenu) {
        coachList.add(new Coach(name, inedibleMenu));
    }

    public List<String> getCoachNames() {
        return coachNames;
    }

    public List<Coach> getCoachList() {
        return coachList;
    }
}
