package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.domain.Coach;
import menu.domain.Coaches;
import menu.utils.ErrorMessage;
import menu.utils.Menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputView {

    private final String FIRST_RUN_MESSAGE = "점심 메뉴 추천을 시작합니다.\n";
    private final String GET_NOT_EATABLE_MENU = "(이)가 못 먹는 메뉴를 입력해 주세요.";
    private static int CHECK_COACHES_NUMBER = 1;
    private static int CHECK_MENU_NUMBER = 2;

    public void startMessage() {
        System.out.println(FIRST_RUN_MESSAGE);
    }

    public Coaches getCoachesName() {
        String[] input = Console.readLine().split(",");
        checkValidCoaches(input);
        return convertStringToCoaches(input);
    }
    public void getNotEatableMenu(Coaches coaches) {
        for (Coach coach : coaches.getCoaches()) {
            System.out.println("\n" +coach.getName() + GET_NOT_EATABLE_MENU);
            String[] input = Console.readLine().split(",");
            checkValidNotEatable(input);
            coach.addNotEatableMenus(input);
        }
    }

    public Coaches convertStringToCoaches(String[] names) {
        List<Coach> coaches = new ArrayList<>();
        for (String name : names) {
            coaches.add(new Coach(name.trim()));
        }
        return new Coaches(coaches);
    }

    public void checkValidNotEatable(String[] input) {
        validNotEatableSize(input);
        validElementDuplicate(input, CHECK_MENU_NUMBER);
        validMenuIsExist(input);
    }

    public void checkValidCoaches(String[] input) {
        validCoachesNameSize(input);
        validElementDuplicate(input, CHECK_COACHES_NUMBER);
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

    public void validElementDuplicate(String[] names, int checkNumber) {
        long originalLength = names.length;
        long distinctLength = Arrays.stream(names).distinct().count();

        if (originalLength != distinctLength) {
            if (checkNumber == CHECK_COACHES_NUMBER) {
                throw new IllegalArgumentException(ErrorMessage.COACH_NAME_IS_NOT_DUPLICATE);
            }
            if (checkNumber == CHECK_MENU_NUMBER) {
                throw new IllegalArgumentException(ErrorMessage.NOT_MENU_NAME_DUPLICATE);
            }
        }
    }

    public void validNotEatableSize(String[] input) {
        if (input.length > 2) {
            throw new IllegalArgumentException(ErrorMessage.NOT_EATABLE_MENU_SIZE_IS_LESS_THAN_TWO);
        }
    }

    public void validMenuIsExist(String[] input) {
        for (String name : input) {
            if (Menu.valueOfMenu(name) == null && !name.trim().isBlank())
                throw new IllegalArgumentException(ErrorMessage.MENU_IS_NOT_EXIST_IS_LIST);
        }
    }

}
