package menu.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import menu.domain.InputException;

public class InputView {
    private final static String INPUT_COACH_NAME = "코치의 이름을 입력해 주세요. (, 로 구분)\n";

    public void getCoachName() {
        System.out.println(INPUT_COACH_NAME);
        String userCoachName = Console.readLine();
        validateCoachNameCount(userCoachName);
        validateDuplicateCoachName(userCoachName);
    }

    public void validateCoachNameCount(String uncheckedCoachNames) {
        List<String> coachNames = List.of(uncheckedCoachNames.split(","));
        if(coachNames.size() < 2) {
            throw new IllegalArgumentException(InputException.OUT_OF_COACH_NAME_COUNT_MINIMUM.getExceptionMessage());
        }
        if(coachNames.size() > 5) {
            throw new IllegalArgumentException(InputException.OUT_OF_COACH_NAME_COUNT_MAXIMUM.getExceptionMessage());
        }
    }

    private void validateDuplicateCoachName(String uncheckedCoachNames) {
        List<String> coachNames = List.of(uncheckedCoachNames.split(","));
        Set<String> uniqueCoachNames = new HashSet<>(coachNames);
        if(coachNames.size() != uniqueCoachNames.size()) {
            throw new IllegalArgumentException(InputException.DUPLICATE_COACH_NAME.getExceptionMessage());
        }
    }
}
