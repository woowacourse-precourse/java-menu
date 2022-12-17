package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.view.validator.Validator;

import java.util.Arrays;
import java.util.List;

public class InputView {

    public List<String> readCoachNames() {
        String input = readValidInputBy(Validator.COACH_NAME);
        List<String> names = Arrays.asList(input.split(Validator.COACH_NAME.getValidDelimiter()));
        validateCoachSize(names);
        validateCoachName(names);
        validateCoachNameDuplication(names);
        return names;
    }

    private void validateCoachSize(List<String> names) {
        int coachCount = names.size();
        if (coachCount < 2 || coachCount > 5) {
            throw new IllegalArgumentException("[ERROR] 코치는 최소 2명, 최대 5명 입력이 가능합니다.");
        }
    }

    private void validateCoachName(List<String> names) {
        for (String name : names) {
            String nameValidFormat = "[가-힣]{2,4}";
            if (!name.matches(nameValidFormat)) {
                throw new IllegalArgumentException("[ERROR] 코치 이름 형식이 올바르지 않습니다.");
            }
        }
    }

    private void validateCoachNameDuplication(List<String> names) {
        if (hasDuplication(names)) {
            throw new IllegalArgumentException("[ERROR] 코치 이름이 중복되었습니다.");
        }
    }

    private boolean hasDuplication(List<String> names) {
        return names.size() != names.stream()
                .distinct()
                .count();
    }

    private String readValidInputBy(Validator validator) {
        String input = Console.readLine();
        validator.validate(input);
        return input;
    }
}
