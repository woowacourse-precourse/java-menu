package menu.view;

import camp.nextstep.edu.missionutils.Console;

import static menu.view.ViewConstants.*;

public class InputView {
    public String getCoachesName() {
        System.out.println(getCoachesNameMessage);
        String userInput = Console.readLine();
        return userInput;
    }

    public String getDislikeMenus(String coachName) {
        System.out.println(coachName + getDislikeMenusMessage);
        String userInput = Console.readLine();
        return userInput;
    }
}
