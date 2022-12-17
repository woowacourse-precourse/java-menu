package menu.view;

import menu.domain.Coach;

public class InputView {

    private static final String INPUT_COACH_NAMES = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final String INPUT_UNEATABLE_MENUS = "(이)가 못 먹는 메뉴를 입력해 주세요.";
    public static final String INPUT_SEPARATOR = ",";
    public void coachNames() {
        System.out.println(INPUT_COACH_NAMES);
    }

    public void unEatableMenu(Coach coach) {
        System.out.println(coach.getName() + INPUT_UNEATABLE_MENUS);
    }
}
