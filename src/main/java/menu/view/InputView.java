package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.message.NoticeMessage;

public class InputView {
    public String inputCoachNames() {
        System.out.println(NoticeMessage.INPUT_COACH_NAMES);
        String input = Console.readLine();
        System.out.println();
        return input;
    }

    public String inputAllegeMenu(String name) {
        System.out.println(name + NoticeMessage.INPUT_ALLEGE_MENU);
        String input = Console.readLine();
        System.out.println();
        return input;
    }
}
