package menu;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {
    Validate validate = new Validate();
    public List<String> readCoachName(){
        while (true){
            System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
            String input = Console.readLine();
            if (validate.isValidCoachName(input)){
                return (Arrays.asList(input.split(",")));
            }
        }
    }
}
