package menu;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String readNames() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
        System.out.println("\n코치의 이름을 입력해 주세요. (, 로 구분)");
        return Console.readLine();
    }

    public String readMenus(String name) {
        System.out.println(name+"(이)가 못 먹는 메뉴를 입력해 주세요.");
        return Console.readLine();
    }
}
