package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.domain.Coach;
import menu.domain.CoachGroup;
import menu.utils.Food;
import org.junit.platform.commons.util.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    private final OutputView outputView;

    public InputView(OutputView outputView) {
        this.outputView = outputView;
    }

    public CoachGroup readCouchName() {
        outputView.printReadCouchName();
        String names = Console.readLine();
        String[] split = names.split(",");
        List<Coach> coaches = Arrays.stream(split)
                .map(Coach::from)
                .collect(Collectors.toList());

        return CoachGroup.from(coaches);
    }

    public List<Food> readCannotFood(Coach coach) {
        outputView.printReadDeniedFood(coach.getName());
        String names = Console.readLine();
        if (StringUtils.isBlank(names)) {
            return null;
        }
        String[] split = names.split(",");
        return Arrays.stream(split)
                .map(String::trim)
                .map(Food::from)
                .collect(Collectors.toList());
    }
}
