package menu;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    public List<String> coachNameInput(){
        List<String> names = new ArrayList<>();
        String[] name = Console.readLine().split(",");
        for(int i=0; i<name.length;i++){
            names.add(name[i]);
            System.out.println(name[i]);
        }
        return names;
    }
    public void coachCantEatInput(){

    }
}
