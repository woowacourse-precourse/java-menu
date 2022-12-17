package menu.view;


import camp.nextstep.edu.missionutils.Console;
import menu.Coach;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static menu.view.InputValidators.*;

public class InputView {
    private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";

    private static final InputView instance = new InputView();

    private InputView() {
    }

    public static InputView getInstance() {
        return instance;
    }

    public List<Coach> readCoach() {
        List<Coach> coaches = null;
        while (true) {
            try {
                System.out.println(
                        "\n" +
                        "코치의 이름을 입력해 주세요. (, 로 구분)");
                String input = Console.readLine();
                String[] names = input.split(",");
                coaches = Arrays.stream(names)
                        .map(Coach::new)
                        .collect(Collectors.toList());

                validateDuplicateCoachName(coaches);
                validateCoachesSize(coaches);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR_MESSAGE_PREFIX + e.getMessage());
            }
        }
        return coaches;
    }




    public List<String> readHateMenu(Coach coach) {
        List<String> hateMenus = null;
        while (true) {
            try {
                System.out.println(coach.getName() + "(이)가 못 먹는 메뉴를 입력해 주세요.");
                String input = Console.readLine();
                String[] names = input.split(",");

                hateMenus = Arrays.asList(names);

                validateHateMenusSize(hateMenus);
                validateDuplicateHateMenuName(hateMenus);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR_MESSAGE_PREFIX + e.getMessage());
            }
        }
        return hateMenus;
    }
}
