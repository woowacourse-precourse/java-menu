package menu.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {


    private static final String INPUT_COACH_NAME_MESSAGE = "\n코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final String INPUT_MENU_MESSAGE = "(이)가 못 먹는 메뉴를 입력해 주세요.";
    public String inputCoachName(){
        System.out.println(INPUT_COACH_NAME_MESSAGE);
        return Console.readLine();
    }

    public String inputMenu(String name){
        System.out.println(name+INPUT_MENU_MESSAGE);
        return Console.readLine();
    }
}
