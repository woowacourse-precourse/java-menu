package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.exception.CatchException;

public class InputConsole {
    static CatchException catchException = new CatchException();
    public static String inputCoachesConsole(){
        String input = Console.readLine();
        catchException.inputOverCoachCntException(input);
        catchException.coachNameLimitException(input);
        catchException.sameNameException(input);
        return input;
    }
    public static String inputCantConsole(){
        String input = Console.readLine();
        return input;
    }
}
