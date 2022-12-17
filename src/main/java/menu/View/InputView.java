package menu.View;

import camp.nextstep.edu.missionutils.Console;
import menu.Util.Validator;

import java.util.List;

public class InputView {
    public static List<String> getCoachList(){
        return Validator.validateCoachList(Console.readLine());
    }

    public static List<String> getAllergy(){
        return Validator.validateAllergyList(Console.readLine());
    }
}
