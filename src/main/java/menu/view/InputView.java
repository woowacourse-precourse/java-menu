package menu.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputView {
    private static String INPUT_COACH_NAME ="코치의 이름을 입력해 주세요. (, 로 구분)";
    private static String INPUT_CANT_EAT_MENU = "(이)가 못 먹는 메뉴를 입력해 주세요.";

    public List<String> inputCoaches(){
        System.out.println(INPUT_COACH_NAME);
        String coachName = Console.readLine();
        return List.of(coachName.split(","));
    }

    public List<String> inputCantEatMenus(String coachName){
        System.out.println(coachName+INPUT_CANT_EAT_MENU);
        String menus = Console.readLine();
        return List.of(menus.split(","));
    }

}
