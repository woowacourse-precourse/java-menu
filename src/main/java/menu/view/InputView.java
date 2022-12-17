package menu.view;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import menu.domain.Coach;
import menu.domain.Coaches;

public class InputView {

    public Coaches sendCoachNames() {
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
        List<String> coachNames = Arrays.asList(Console.readLine().split(","));
        return coachNames.stream()
                .map(Coach::new)
                .collect(collectingAndThen(toList(), Coaches::new));
    }
}
