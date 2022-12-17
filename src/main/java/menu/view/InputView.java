package menu.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import menu.domain.Coach;
import menu.util.Converter;
import menu.util.Validator;

public class InputView {

    public static List<Coach> inputCoaches() {
        System.out.println("코치 이름을 입력해 주세요. (, 로 구분)");
        String input = Console.readLine();
        List<Coach> coaches = Converter.stringToCoaches(input);
        Validator.validateCoaches(coaches);
        return coaches;
    }
}
