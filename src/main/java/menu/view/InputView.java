package menu.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import menu.SystemMessage;

public class InputView {

    public static List<String> readCoachName() {
        System.out.println(SystemMessage.COACH_NAME_INPUT_MESSAGE);
        String names = Console.readLine();
        List<String> coachNames = new ArrayList<>();
        coachNames = Arrays.asList(names.split(","));
        return coachNames;
    }

    public static List<String> readDislikeMenu() {
        System.out.println(SystemMessage.DISLIKE_MENU_INPUT_MESSAGE);
        String names = Console.readLine();
        List<String> dislikeMenus = new ArrayList<>();
        dislikeMenus = Arrays.asList(names.split(","));
        return dislikeMenus;
    }
}
