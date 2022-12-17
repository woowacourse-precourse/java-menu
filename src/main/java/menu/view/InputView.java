package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.domain.Coach;
import menu.domain.Coaches;
import menu.utils.ErrorMessage;
import menu.utils.Menu;
import menu.utils.Validation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputView {
    private final String GET_NOT_EATABLE_MENU = "(이)가 못 먹는 메뉴를 입력해 주세요.";
    private static int CHECK_COACHES_NUMBER = 1;
    private static int CHECK_MENU_NUMBER = 2;

    public Coaches getCoachesName() {
        String[] input = Console.readLine().split(",");
        Validation.checkValidCoaches(input);
        return convertStringToCoaches(input);
    }
    public void getNotEatableMenu(Coaches coaches) {
        for (Coach coach : coaches.getCoaches()) {
            System.out.println("\n" +coach.getName() + GET_NOT_EATABLE_MENU);
            String[] input = Console.readLine().split(",");
            Validation.checkValidNotEatable(input);
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

}
