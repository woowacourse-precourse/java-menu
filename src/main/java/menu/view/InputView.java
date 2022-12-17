package menu.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import menu.domain.Menu;
import menu.dto.CoachDto;
import menu.dto.CoachNameDto;
import menu.dto.CoachNamesDto;

public class InputView {
    private static final String DELIMITER = ",";

    public static CoachNamesDto readCoachNames() {
        OutputView.printReadCoachNames();
        String names = Console.readLine();
        List<String> coaches = Arrays.stream(names.split(DELIMITER))
                .collect(Collectors.toList());
        return new CoachNamesDto(coaches);
    }

    public static CoachDto readCantEatMenu(CoachNameDto coachNameDto) {
        //안내 문구 출력 -> 코치 이름 출력
        String menus = Console.readLine();
        List<Menu> cantEatMenus = Arrays.stream(menus.split(DELIMITER))
                .map(Menu::from)
                .collect(Collectors.toList());
        return new CoachDto(coachNameDto.getName(), cantEatMenus);
    }

}
