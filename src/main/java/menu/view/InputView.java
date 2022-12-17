package menu.view;

import camp.nextstep.edu.missionutils.Console;

import static menu.view.ViewConstants.*;

public class InputView {
    public String getCoachesName() {
        System.out.println(GET_COACHES_NAME_MESSAGE);
        String userInput = Console.readLine();
        System.out.println();
        return userInput;
    }

    public String getDislikeMenus(String coachName) {
        System.out.println(coachName + GET_DISLIKE_MENUS_MESSAGE);
        String userInput = Console.readLine();
        System.out.println();
        return userInput;
    }
}
