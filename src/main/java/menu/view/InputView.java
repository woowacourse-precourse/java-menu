package menu.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {


    private static final String INPUT_COACH_NAME_MESSAGE = "\n코치의 이름을 입력해 주세요. (, 로 구분)";

    public String inputCoachName(){
        System.out.println(INPUT_COACH_NAME_MESSAGE);
        return Console.readLine();
    }
}
