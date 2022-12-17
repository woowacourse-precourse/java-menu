package menu;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    public static String requestCoachName() {
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
        return readLine();
    }

    public static String requestNotPreferMenu(String name) {
        System.out.println(name + "(이)가 못 먹는 메뉴를 입력해 주세요.");
        return readLine();
    }
}
