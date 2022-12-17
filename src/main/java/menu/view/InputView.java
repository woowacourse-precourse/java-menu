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

    public Map<String, List<String>> getHateList(String name){
        Map<String, List<String>> hateMap = new HashMap<>();
        outputView.askCoachHate(name);
        String hateString = Console.readLine();
        List<String> hateList = Arrays.asList(hateString.split(","));
        hateMap.put(name, hateList);
        return hateMap;
    }

}
