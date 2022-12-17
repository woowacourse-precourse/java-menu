package menu;

import camp.nextstep.edu.missionutils.Console;
public class InputView {

    // 코치 이름들
    public String readCoach(){
        System.out.println(GuidanceMessage.INPUT_COACH_NAME);
        return Console.readLine();
    }

    // 못먹는 메뉴(들)
    public String readInedible(){
        System.out.println(GuidanceMessage.INPUT_INEDIBLE);
        return Console.readLine();
    }

}
