package menu.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import menu.domain.Coach;
import menu.domain.Menu;
import menu.repository.CoachRepository;
import menu.repository.MenuRepository;
import menu.utils.Parser;
import menu.validator.CoachDuplicateValidator;
import menu.validator.CoachGroupSizeValidator;
import menu.validator.CoachNameSizeValidator;
import menu.validator.NoEatableMenuSizeValidator;
import menu.validator.SizeValidator;
import menu.view.InputView;
import menu.view.OutputView;

public class CoachController {
    private static final String BLANK = "";
    private static final int FIRST_INDEX = 0;
    private static final String COACH_DELIMITER = ",";
    private static final String NO_EATABLE_MENU_DELIMITER = ",";


    public void addCoaches() {
        addCoachesByName();
        addNoEatableMenuOfCoaches(CoachRepository.coaches());
    }

    private void addCoachesByName() {
        List<Coach> coaches = new ArrayList<>();
        try {
            coaches = createCoachesByNames(getParsedCoachNames());
            validate(coaches);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            addCoachesByName();
        }
        CoachRepository.addAll(coaches);
    }

    private void validate(List<Coach> coaches) {
        SizeValidator coachGroupSizeValidator = new CoachGroupSizeValidator();
        coachGroupSizeValidator.validate(coaches.size());
        CoachDuplicateValidator coachDuplicateValidator = new CoachDuplicateValidator();
        coachDuplicateValidator.validate(coaches);
    }

    private List<Coach> createCoachesByNames(List<String> names) {
        List<Coach> coaches = new ArrayList<>();
        for (String name : names) {
            validateName(name);
            coaches.add(new Coach(name));
        }
        return coaches;
    }

    private void validateName(String name) {
        SizeValidator coachNameSizeValidator = new CoachNameSizeValidator();
        coachNameSizeValidator.validate(name.length());
    }

    private List<String> getParsedCoachNames() {
        String names = InputView.inputCoachNames();
        return Parser.parse(names, COACH_DELIMITER);
    }

    private void addNoEatableMenuOfCoaches(List<Coach> coaches) {
        for (Coach coach : coaches) {
            addNoEatableMenuOfCoach(coach);
        }
    }

    private void addNoEatableMenuOfCoach(Coach coach) {
        try {
            String inputNoEatableMenus = InputView.inputNoEatableMenus(coach.getName());
            List<Menu> parsedMenus = getParsedNoEatableMenu(inputNoEatableMenus);
            if (parsedMenus == null) {
                return;
            }
            coach.addNoEatableMenuAll(parsedMenus);
            // update coach
            CoachRepository.update(CoachRepository.getIndex(coach), coach);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            addNoEatableMenuOfCoach(coach);
        }
    }

    private List<Menu> getParsedNoEatableMenu(String inputNoEatableMenus) { //TODO Parsing util클래스 생성
        List<String> parsedNames = Parser.parse(inputNoEatableMenus, NO_EATABLE_MENU_DELIMITER);
        validateNoEatableMenuSize(parsedNames.size());
        if (parsedNames.get(FIRST_INDEX).equals(BLANK)) {
            return null;
        }
        return parsedNames.stream().map(parsedName -> {
            return MenuRepository.findByName(parsedName);
        }).collect(Collectors.toList());
    }

    private void validateNoEatableMenuSize(int size) {
        SizeValidator noEatableMenuSizeValidator = new NoEatableMenuSizeValidator();
        noEatableMenuSizeValidator.validate(size);
    }
}
