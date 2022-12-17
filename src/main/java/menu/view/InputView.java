package menu.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import menu.dto.CoachNamesDto;

public class InputView {
    private static final String DELIMITER = ",";

    public static CoachNamesDto readGroup() {
        //안내 문구 출력
        String names = Console.readLine();
        List<String> coaches = Arrays.stream(names.split(DELIMITER))
                .collect(Collectors.toList());
        return new CoachNamesDto(coaches);
    }

}
