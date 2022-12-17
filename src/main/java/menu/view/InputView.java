package menu.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String coachNameInput() {
        String coach = Console.readLine();
        return coach;
    }

    public String menuInput() {
        String menu = Console.readLine();
        return menu;
    }
}
