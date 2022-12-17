package menu.view;

import static java.util.stream.Collectors.toList;

import camp.nextstep.edu.missionutils.Console;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.stream.Collectors;
import menu.dto.CoachNameDto;

public class InputView {

    private static final String READ_COACH_NAMES_MESSAGE = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final String READ_MENU_NAMES_MESSAGE = "{0}(이)가 못 먹는 메뉴를 입력해 주세요.";

    public CoachNameDto readCoachNames() {
        System.out.println(READ_COACH_NAMES_MESSAGE);
        String names = Console.readLine();
        return toCoachName(names);
    }

    private CoachNameDto toCoachName(String names) {
        return Arrays.stream(names.split(",", -1))
                .collect(Collectors.collectingAndThen(toList(), CoachNameDto::new));
    }

    public String readMenuNames(String name) {
        System.out.println(MessageFormat.format(READ_MENU_NAMES_MESSAGE, name));
        String menuNames = Console.readLine();
        return menuNames;
    }
}
