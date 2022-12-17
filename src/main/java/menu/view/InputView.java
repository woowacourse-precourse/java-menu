package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.domain.Couch;
import menu.domain.Food;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    private final OutputView outputView;

    public InputView(OutputView outputView) {
        this.outputView = outputView;
    }

    public List<Couch> readCouchName() {
        outputView.printReadCouchName();
        String names = Console.readLine();
        String[] split = names.split(",");

        return Arrays.stream(split)
                .map(Couch::from)
                .collect(Collectors.toList());
    }

    public List<Food> readCannotFood(Couch couch) {
        outputView.printReadDeniedFood(couch.getName());
        String names = Console.readLine();
        String[] split = names.split(",");
        return Arrays.stream(split)
                .map(Food::valueOf)
                .collect(Collectors.toList());
    }
}
