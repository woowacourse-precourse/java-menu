package menu.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InputView {
    OutputView outputView = new OutputView();

    public List<String> getCoachList() {
        outputView.initMessage();
        String coachString = Console.readLine();
        List<String> coachList = Arrays.asList(coachString.split(","));
        return coachList;
    }

    public List<String> getHateList(String name) {
        outputView.askCoachHate(name);
        String hateString = Console.readLine();
        if (hateString == null) {
            return List.of();
        }
        if (!(hateString.contains(","))) {
            return List.of(hateString);
        }
        List<String> hateFoodList = Arrays.asList(hateString.split(","));
        return hateFoodList;
    }

}
