package menu.view.validation;

import java.util.ArrayList;
import java.util.List;

import static menu.Menu.staticMenu;

public class MenuValidation {

    private static List<List<String>> menus = staticMenu;

    public static boolean menuValidation(String input) {
        try {
            isInRange(init(input));
            isInMenu(init(input));
            return true;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static List<String> init(String input){
        String[] values = input.split(",");
        List<String> names = new ArrayList<>();
        for(String value : values){
            names.add(value);
        }
        return names;
    }

    private static void isInMenu(List<String> inputs) {
        boolean isIn = false;
        for(List<String> menu : menus){
            if(check(inputs,menu)){
                isIn=true;
            }
        }
        if(!isIn){
            System.out.println("메뉴안에 없음");
            throw new IllegalArgumentException();
        }
    }
    private static boolean check(List<String> inputs, List<String> menu){
        for(String input : inputs){
            if(menu.contains(input)){
                return true;
            }
        }
        return false;
    }
    private static void isInRange(List<String> input) {
        if (input.size() > 3) {
            System.out.println("2개까지만 입력 가능");
            throw new IllegalArgumentException();
        }
    }
}
