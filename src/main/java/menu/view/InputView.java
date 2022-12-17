package menu.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private InputView() {
    }

    public static String inputCoachName() {
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
        return Console.readLine();
    }

    public static String inputCanNotEatMenus(String coachName) {
        System.out.printf("%s가 못 먹는 메뉴를 입력해 주세요.", coachName);
        System.out.println();
        return Console.readLine();
    }
}
