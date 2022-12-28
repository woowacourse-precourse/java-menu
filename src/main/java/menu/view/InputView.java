package menu.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InputView {
    private static final String COMMA = ",";
    private static final int MAX_NAME_LENGTH = 4;
    private static final int MIN_NAME_LENGTH = 2;
    private static final int MAX_MENU_LENGTH = 2;

    OutputView outputView = new OutputView();

    public List<String> getCoachList() {
        outputView.initMessage();
        String coachString = Console.readLine();
        List<String> coachList = Arrays.asList(coachString.split(COMMA));
        for (int i = 0; i < coachList.size(); i++) {
            if (coachList.get(i).length() < MIN_NAME_LENGTH || coachList.get(i).length() > MAX_NAME_LENGTH) {
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
        if (!(hateString.contains(COMMA))) {
            return List.of(hateString);
        }
        List<String> hateFoodList = Arrays.asList(hateString.split(COMMA));
        if (hateFoodList.size() > MAX_MENU_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 못먹는 메뉴는 두 개까지만 입력가능합니다");
        }
        System.out.println(hateFoodList);
        return hateFoodList;
    }

}
