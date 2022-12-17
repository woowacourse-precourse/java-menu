package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.domain.Coach;

import static menu.utils.ViewMessage.*;

public class InputView {
    public static String readCoachName() {
        System.out.println(REQUEST_COACH_NAME);
        return Console.readLine();
    }

    public static String readCoachDoNotEatFood(Coach coach) {
        System.out.printf(REQUEST_COACH_DO_NOT_EAT_FOOD, coach.getName());
        return Console.readLine();
    }
}
