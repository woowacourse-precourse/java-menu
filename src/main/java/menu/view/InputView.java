package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.domain.Coach;

public class InputView {

    private static final String INPUT_COACH_NAME = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final String INPUT_COACH_INEDIBLE_FOOD_FORMAT = "%s(이)가 못 먹는 메뉴를 입력해 주세요.";

    /**
     * 코치 이름 입력
     */
    public static String inputCoachName() {
        System.out.println(INPUT_COACH_NAME);
        return Console.readLine();
    }

    /**
     * 못 먹는 음식 입력
     */
    public static String inputInedibleFoodForCoach(final Coach coach) {
        String message = String.format(INPUT_COACH_INEDIBLE_FOOD_FORMAT, coach.name());
        System.out.println(message);
        return Console.readLine();
    }
}
