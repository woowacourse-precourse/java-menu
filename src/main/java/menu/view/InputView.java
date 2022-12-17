package menu.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    private final String REQUIRE_COACH_NAME = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private final String REQUIRE_COACH_EXCLUDE_MENU_FORMAT = "%s(이)가 못 먹는 메뉴를 입력해 주세요.\n";

    public String[] readCoachNames() {
        System.out.println(REQUIRE_COACH_NAME);
        //개수 validation
        return readLine().split(",");
    }

    public String[] readExcludeMenu(String coach) {
        System.out.printf(REQUIRE_COACH_EXCLUDE_MENU_FORMAT, coach);
        //개수 validation
        return readLine().split(",");

    }
}
