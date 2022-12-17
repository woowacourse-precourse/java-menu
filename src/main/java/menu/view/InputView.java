package menu.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_COACH_NAMES = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final String INPUT_NOT_EAT = "(이)가 못 먹는 메뉴를 입력해 주세요.";

    public String readCoachNames() {
        System.out.println(INPUT_COACH_NAMES);

        String name = Console.readLine();

        System.out.println();

        return name;
    }

    public String readNotEatMenus(String coachName) {
        System.out.print(coachName);
        System.out.println(INPUT_NOT_EAT);

        String notEatMenus = Console.readLine();

        System.out.println();

        return notEatMenus;
    }
}
