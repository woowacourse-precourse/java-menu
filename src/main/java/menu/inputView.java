package menu;

import camp.nextstep.edu.missionutils.Console;

public class inputView {

    public String readNames() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
        System.out.println("\n코치의 이름을 입력해 주세요. (, 로 구분)");
        return Console.readLine();
    }

    public String readMenus() {
        return Console.readLine();
    }
}
