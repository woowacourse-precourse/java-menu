package menu.view;

import static menu.view.InputConsole.inputCantConsole;
import static menu.view.InputConsole.inputCoachesConsole;

public class InputView {
    public static String inputCoachesView(){
        String input ="";
        try{
            System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
            input = inputCoachesConsole();

        }catch(IllegalArgumentException e){
            System.out.println(e);
            input = inputCoachesView();
        }
        return input;
    }
    public static String inputCantView(String coach){
        String input ="";
        try{
            System.out.println(coach+"(이)가 못 먹는 메뉴를 입력해 주세요.");
            input = inputCantConsole();
        }catch(IllegalArgumentException e){
            System.out.println(e);
            input = inputCantView(coach);
        }
        return input;
    }
}
