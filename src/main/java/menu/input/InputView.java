package menu.input;

import camp.nextstep.edu.missionutils.Console;
import menu.output.OutputString;

public class InputView {

    public String[] INPUT_COACH_NAME(){
        System.out.println(InputString.COACH_NAME_INPUT);
        String names = Console.readLine();
        return names.split(",");
    }

    public String[] CANNOT_EAT_FOOD(String name){
        System.out.println(name + InputString.CANNOT_EAT_FOOD);
        String m = Console.readLine();
        return m.split(",");
    }

}
