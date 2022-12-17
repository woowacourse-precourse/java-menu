package menu.view;

import static java.util.stream.Collectors.toList;

import camp.nextstep.edu.missionutils.Console;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.stream.Collectors;
import menu.domain.Menu;
import menu.dto.CoachNameDto;
import menu.dto.InvalidMenusDto;

public class InputView {

    private static final String READ_COACH_NAMES_MESSAGE = "\n코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final String READ_MENU_NAMES_MESSAGE = "\n{0}(이)가 못 먹는 메뉴를 입력해 주세요.";
    private static final String DELIMITER = ",";
    private static final int SPLIT_INDEX = -1;

    public CoachNameDto readCoachNames() {
        System.out.println(READ_COACH_NAMES_MESSAGE);
        String names = Console.readLine();
        InputValidator.validateCoachName(names);
        return toCoachName(names);
    }

    private CoachNameDto toCoachName(String names) {
        return Arrays.stream(names.split(DELIMITER, SPLIT_INDEX))
                .collect(Collectors.collectingAndThen(toList(), CoachNameDto::new));
    }

    public InvalidMenusDto readMenuNames(String name) {
        System.out.println(MessageFormat.format(READ_MENU_NAMES_MESSAGE, name));
        String names = Console.readLine();
        InputValidator.validateMenuNames(names);
        return toMenuNames(names);
    }

    private InvalidMenusDto toMenuNames(String names) {
        return Arrays.stream(names.split(DELIMITER, SPLIT_INDEX))
                .map(Menu::new)
                .collect(Collectors.collectingAndThen(toList(), InvalidMenusDto::new));
    }
}
