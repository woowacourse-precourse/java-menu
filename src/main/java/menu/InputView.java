package menu;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    public List<String> coachNameInput(){
        List<String> names = new ArrayList<>();
        String[] name = Console.readLine().split(",");
        if(name.length<2 || name.length>5)
            throw new IllegalArgumentException("[ERROR] 최소2명 최대 5명 입력");
        for(int i=0; i<name.length;i++){
            if(validateName(name[i])) {
                names.add(name[i]);
            }
        }
        return names;
    }
    public boolean validateName(String name){
        if(name.length()<2 || name.length()>5){
            throw new IllegalArgumentException("[ERROR] 최소 2글자, 최대 4글자 입력");
        }
        return true;
    }



    public List<String> coachCantEatInput(){
        List<String> notEatFood = new ArrayList<>();
        String[] menu = Console.readLine().split(",");
        if(menu.length<0 || menu.length>2)
            throw new IllegalArgumentException("[ERROR] 최소0개 최대 2개 입력");

        for(int i=0; i<menu.length;i++){
            notEatFood.add(menu[i]);
        }
        return notEatFood;
    }
}
