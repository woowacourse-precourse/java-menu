package menu.view;

import static menu.view.InputConsole.inputCantConsole;
import static menu.view.InputConsole.inputCoachesConsole;

public class InputView {
    public static String inputCoachesView(){
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
        return inputCoachesConsole();
    }
    public static String inputCantView(String coach){
        System.out.println(coach+"(이)가 못먹는 메뉴를 입력해 주세요.");
        return inputCantConsole();
    }
}
