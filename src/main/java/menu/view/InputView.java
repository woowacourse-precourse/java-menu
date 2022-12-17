package menu.view;

import camp.nextstep.edu.missionutils.Console;

public class InputVIew {
    public static String getCoachNameInput() {
        System.out.println("\n코치의 이름을 입력해 주세요. (, 로 구분)");
        return Console.readLine();
    }

    public static String getHateMenu(String coach) {
        System.out.printf("%n%s(이)가 못 먹는 메뉴를 입력해 주세요.%n", coach);
        return Console.readLine();
    }
}
