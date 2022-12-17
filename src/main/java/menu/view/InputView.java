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
        for (int i = 0; i < coachList.size(); i++) {
            if (coachList.get(i).length() < 2 || coachList.get(i).length() > 4) {
                throw new IllegalArgumentException("[ERROR] 코치이름의 길이를 확인해주세요");
            }
        }
        if (coachList.size() > 5 || coachList.size() < 2) {
            throw new IllegalArgumentException("[ERROR] 코치는 두 명과 다섯명 사이로 입력해주세요");
        }
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
