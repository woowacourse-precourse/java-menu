package menu.view;


import camp.nextstep.edu.missionutils.Console;
import menu.entity.Coach;

import java.util.Arrays;
import java.util.List;
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
        List<Coach> coaches;
        while (true) {
            try {
                System.out.println("\n" + "코치의 이름을 입력해 주세요. (, 로 구분)");
                coaches = mapNameToCoach(Console.readLine().split(","));
                validateDuplicateCoachName(coaches);
                validateCoachesSize(coaches);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR_MESSAGE_PREFIX + e.getMessage());
            }
        }
        return coaches;
    }

    private List<Coach> mapNameToCoach(String[] names) {
        return Arrays.stream(names)
                .map(Coach::nameOf)
                .collect(Collectors.toList());
    }

    public List<String> readHateMenu(Coach coach) {
        List<String> hateMenus;
        while (true) {
            try {
                System.out.println(coach.getName() + "(이)가 못 먹는 메뉴를 입력해 주세요.");
                hateMenus = Arrays.asList(Console.readLine().split(","));
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
