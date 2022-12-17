package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.model.Coach;
import menu.model.Validator;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    public static List<Coach> inputCoach() {
        String input = Console.readLine();
        Validator.validateCoach(input);
        String[] coaches = input.split(",");
        List<Coach> list = new ArrayList<>();
        for (String name : coaches) {
            Coach coach = new Coach(name);
            list.add(coach);
        }
        return list;
    }

    public static List<String> inputNoEat() {
        String input = Console.readLine();
        String[] foods = input.split(",");
        List<String> list = new ArrayList<>();
        for (String food : foods) {
            list.add(food);
        }
        return list;
    }
}
