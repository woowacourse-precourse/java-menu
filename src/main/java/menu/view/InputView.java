package menu.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputView {

    public String readNames() {
        return Console.readLine();
    }


    public List<String> readCantEat() {
        String input = Console.readLine();
        if(!input.equals("")){
            String [] cantEat = makeArray(input);
            return Arrays.asList(cantEat);
        }
        return new ArrayList<>();
    }

    private String[] makeArray(String input) {
        String [] tmpArray = input.split(",");
        for(int i=0;i< tmpArray.length;i++){
            tmpArray[i] = tmpArray[i].replace(" ","");
        }
        return tmpArray;
    }
}
