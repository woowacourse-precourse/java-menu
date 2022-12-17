package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.domain.Coach;
import menu.domain.NotEatableFood;

import java.util.List;

import static menu.domain.Coach.validateCoachNames;
import static menu.domain.NotEatableFood.createNotEatableFood;
import static menu.view.OutputView.printCoachNames;
import static menu.view.OutputView.printGetCoachNameMessage;

public class InputView {
    private static final String NOT_EATABLE_FOOD_SUB_MESSAGE = "(이)가 못 먹는 메뉴를 입력해 주세요.";

    public static List<String> getCoachName() {
        printGetCoachNameMessage();
        String names = Console.readLine();
        List<String> coachNames = List.of(names.split(","));
        validateCoachNames(coachNames);
        printCoachNames(coachNames);
        return coachNames;
    }

    public static NotEatableFood getNotEatableFood(String name) {
        printGetNotEatableFoodMessage(name);
        String notEatableFoodsInput = Console.readLine();
        return createNotEatableFood(notEatableFoodsInput);
    }

    private static void printGetNotEatableFoodMessage(String name) {
        System.out.println(name + NOT_EATABLE_FOOD_SUB_MESSAGE);
    }

}
