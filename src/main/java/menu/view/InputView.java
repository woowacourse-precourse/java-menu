package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.domain.Coach;
import menu.domain.Coaches;

import java.util.ArrayList;
import java.util.List;

public class InputView {

    private final String FIRST_RUN_MESSAGE = "점심 메뉴 추천을 시작합니다.\n";

    public void startMessage() {
        System.out.println(FIRST_RUN_MESSAGE);
    }

    public Coaches getCoachesName() {
        String[] input = Console.readLine().split(",");
        return convertStringToCoaches(input);
    }

    public Coaches convertStringToCoaches(String[] names) {
        List<Coach> coaches = new ArrayList<>();
        for (String name : names) {
            coaches.add(new Coach(name));
        }
        return new Coaches(coaches);
    }
}
