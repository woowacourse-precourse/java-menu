package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.domain.Couch;
import menu.domain.CouchGroup;
import menu.domain.Food;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    private final OutputView outputView;

    public InputView(OutputView outputView) {
        this.outputView = outputView;
    }

    public CouchGroup readCouchName() {
        outputView.printReadCouchName();
        String names = Console.readLine();
        String[] split = names.split(",");
        List<Couch> couches = Arrays.stream(split)
                .map(Couch::from)
                .collect(Collectors.toList());

        return CouchGroup.from(couches);
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
