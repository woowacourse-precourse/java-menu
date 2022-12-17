package menu;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {

    public List<String> coachNameInput() {
        List<String> names = new ArrayList<>();
        String[] name = validateNumber();

        for (String addName : name)
            names.add(addName);
        return names;
    }

    public String[] validateNumber(){
        while(true) {
            String[] name = Console.readLine().split(",");
            try {
                validateNumberThrow(name);
                return name;
            }
            catch(IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public void validateNumberThrow(String[] name) throws IllegalArgumentException{
        if (name.length < 2 || name.length > 5)
            throw new IllegalArgumentException("[ERROR] 최소2명 최대 5명 입력");
        if(validateName(name))
            throw new IllegalArgumentException("[ERROR] 최소 2글자, 최대 4글자 입력");
    }

    public boolean validateName(String[] name) throws IllegalArgumentException{
        for (String validateName : name) {
            if (validateName.length() < 2 || validateName.length() > 4) {
                return true;
            }
        }
        return false;
    }

    public List<String> coachCantEatInput(){
        List<String> notEatFood = new ArrayList<>();
        String[] menu=validateCantEat();

        for (String food : menu) {
            notEatFood.add(food);
        }
        return notEatFood;
    }

    public String[] validateCantEat(){
        String[] menu;
        while(true) {
            menu = Console.readLine().split(",");
            try {
                validateCantEatThrow(menu);
                break;
            }
            catch(IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return menu;
    }

    public void validateCantEatThrow(String[] menu){
        if(menu.length>2)
            throw new IllegalArgumentException("[ERROR] 최소0개 최대 2개 입력");
    }
}
