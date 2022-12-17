package menu.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.exception.InputException;

public class InputView {
    private final static String INPUT_COACH_NAME = "코치의 이름을 입력해 주세요. (, 로 구분)\n";
    private final static String INPUT_COACH_CAN_NOT_EAT_MENUS = "(이)가 못 먹는 메뉴를 입력해 주세요.";

    public List<String> getCoachName() {
        System.out.println(INPUT_COACH_NAME);
        String coachNameInput = Console.readLine();
        validateCoachNameCount(coachNameInput);
        validateDuplicateCoachName(coachNameInput);
        validateCoachNameLength(coachNameInput);
        List<String> coachNames = convertStringToList(coachNameInput);
        return coachNames;
    }

    public List<Coach> getCoachCannotEatMenus(List<String> coachNames) {
        List<Coach> coaches = new ArrayList<>();
        for (String coachName : coachNames) {
            System.out.println(coachName + INPUT_COACH_CAN_NOT_EAT_MENUS);
            String menuNameInput = Console.readLine();
            validateCannotEatMenus(menuNameInput);
            List<String> coachCannotEatMenus = convertStringToList(menuNameInput);
            Coach coach = new Coach(coachName, coachCannotEatMenus);
            coaches.add(coach);
        }
        return coaches;
    }

    public void validateCoachNameCount(String uncheckedCoachNames) {
        List<String> coachNames = List.of(uncheckedCoachNames.split(","));
        if (coachNames.size() < 2) {
            throw new IllegalArgumentException(InputException.OUT_OF_COACH_NAME_COUNT_MINIMUM.getExceptionMessage());
        }
        if (coachNames.size() > 5) {
            throw new IllegalArgumentException(InputException.OUT_OF_COACH_NAME_COUNT_MAXIMUM.getExceptionMessage());
        }
    }

    private void validateDuplicateCoachName(String uncheckedCoachNames) {
        List<String> coachNames = List.of(uncheckedCoachNames.split(","));
        Set<String> uniqueCoachNames = new HashSet<>(coachNames);
        if (coachNames.size() != uniqueCoachNames.size()) {
            throw new IllegalArgumentException(InputException.DUPLICATE_COACH_NAME.getExceptionMessage());
        }
    }

    private void validateCoachNameLength(String uncheckedCoachNames) {
        List<String> coachNames = List.of(uncheckedCoachNames.split(","));
        for (String coachName : coachNames) {
            if (coachName.length() < 2) {
                throw new IllegalArgumentException(
                        InputException.OUT_OF_COACH_NAME_COUNT_MINIMUM.getExceptionMessage());
            }
            if (coachName.length() > 4) {
                throw new IllegalArgumentException(
                        InputException.OUT_OF_COACH_NAME_LENGTH_MAXIMUM.getExceptionMessage());
            }
        }
    }

    private List<String> convertStringToList(String checkedCoachNames) {
        List<String> coachNames = List.of(checkedCoachNames.split(","));
        return coachNames;
    }

    public void validateCannotEatMenus(String uncheckedMenus) {
        validateDuplicateMenus(uncheckedMenus);
        validateMenuInCategory(uncheckedMenus);
    }

    private void validateDuplicateMenus(String uncheckedMenus) {
        List<String> cannotEatMenus = convertStringToList(uncheckedMenus);
        Set<String> uniqueCoachNames = new HashSet<>(cannotEatMenus);
        if(cannotEatMenus.size() != uniqueCoachNames.size()) {
            throw new IllegalArgumentException(InputException.DUPLICATE_COACH_MENUS.getExceptionMessage());
        }
    }

    private void validateMenuInCategory(String uncheckedMenus) {
        List<String> cannotEatMenus = convertStringToList(uncheckedMenus);
        for(String cannotEatMenu : cannotEatMenus) {
            Category menuCategory = Category.validateMenu(cannotEatMenu);
            if(menuCategory == Category.INVALID_CATEGORY) {
                throw new IllegalArgumentException(InputException.INVALID_MENU.getExceptionMessage());
            }
        }
    }
}
