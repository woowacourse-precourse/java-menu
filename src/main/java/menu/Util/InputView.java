package menu.Util;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static void getCoachList(){
        Validator.validateCoachList(Console.readLine());
    }

    public static void getAllergy(){
        Console.readLine();
    }
}
