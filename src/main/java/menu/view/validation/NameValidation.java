package menu.view.validation;

import java.util.ArrayList;
import java.util.List;

public class NameValidation {

    public static boolean nameValidation(String input) {
        try {
            isInRangeOfPeopleSize(init(input));
            isInRangeOfNameSize(init(input));
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

    private static void isInRangeOfNameSize(List<String> inputs) {
        for(String input : inputs){
            if (input.length() < 2 || input.length() > 4) {
                System.out.println("2~4글자만 입력 가능");
                throw new IllegalArgumentException();
            }
        }
    }

    private static void isInRangeOfPeopleSize(List<String> input) {
        if (input.size() < 2 || input.size() > 5) {
            System.out.println("2~5명만 입력 가능");
            throw new IllegalArgumentException();
        }
    }
}
