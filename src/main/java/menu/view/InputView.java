package menu.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import menu.coach.Coach;
import menu.coach.Coaches;

public class InputView {

    public void inputCoaches() {
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");

        Coaches.listToCoaches(checkComma(Console.readLine()));
    }

    public void inputCoachesHateFoods() {
        for (Coach coach : Coaches.getCoaches()) {
            System.out.println(coach.getName() + "(이)가 못 먹는 메뉴를 입력해 주세요.");
            String input = Console.readLine();
            Coaches.inputHateFood(coach.getName(), checkComma(input));
        }
    }

    public List<String> checkComma(String input) {
        return List.of(input.split(","));
    }
}
