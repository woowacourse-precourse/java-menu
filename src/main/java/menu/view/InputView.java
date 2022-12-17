package menu.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import menu.view.Message.*;


public class InputView {
    List<String> CoachList;

    public List<String> getNameList(){
        String inputCoaches = Console.readLine();
        CoachList = Arrays.asList(inputCoaches.split(","));
        return CoachList;
    }

}
