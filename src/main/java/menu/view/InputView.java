package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.domain.Coach;
import menu.domain.Coaches;
import menu.utils.ErrorMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputView {

    private final String FIRST_RUN_MESSAGE = "점심 메뉴 추천을 시작합니다.\n";

    public void startMessage() {
        System.out.println(FIRST_RUN_MESSAGE);
    }

    public Coaches getCoachesName() {
        String[] input = Console.readLine().split(",");
        checkValidCoaches(input);
        return convertStringToCoaches(input);
    }

    public Coaches convertStringToCoaches(String[] names) {
        List<Coach> coaches = new ArrayList<>();
        for (String name : names) {
            coaches.add(new Coach(name.trim()));
        }
        return new Coaches(coaches);
    }

    public void checkValidCoaches(String[] input) {
        validCoachesNameSize(input);
        validCoachesNameDuplicate(input);
        for (String name : input) {
            validCoachNameSize(name.trim());
        }
    }

    public void validCoachNameSize(String name) {
        if (name.length() < 2 || name.length() > 5) {
            throw new IllegalArgumentException(ErrorMessage.COACH_NAME_SIZE_IS_BETWEEN_TWO_AND_FOUR);
        }
    }

    public void validCoachesNameSize(String[] names) {
        if (names.length < 2 || names.length > 5) {
            throw new IllegalArgumentException(ErrorMessage.COACH_IS_LEAST_TWO_AND_MAX_FIVE);
        }
    }

    public void validCoachesNameDuplicate(String[] names) {
        long originalLength = names.length;
        long distinctLength = Arrays.stream(names).distinct().count();

        if (originalLength != distinctLength) {
            throw new IllegalArgumentException(ErrorMessage.COACH_NAME_IS_NOT_DUPLICATE);
        }
    }
}
