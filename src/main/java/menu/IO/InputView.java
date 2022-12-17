package menu.IO;

import camp.nextstep.edu.missionutils.Console;
import menu.exception.CustomIllegalArgumentException;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class InputView {
    /**
     * 각각의 상수는 에러범위 지정을 한다.
     */
    final int MIN_NAME_LENGTH = 2;
    final int MAX_NAME_LENGTH = 4;
    final int MIN_DONT_ENT_MENU_NUM = 0;
    final int MAX_DONT_ENT_MENU_NUM = 2;
    final int MIN_COACH_NUM = 2;
    final int MAX_COACH_NUM = 5;

    /**
     * 코치 이름을 입력받는다. 잘못된 입력이면 에러를 던진다.
     *
     * @return
     */
    public List<String> readCoachNames() {
        String names = Console.readLine();
        StringTokenizer tokenizer = new StringTokenizer(names, ",");
        List<String> coachNames = new ArrayList<>();
        while (tokenizer.hasMoreTokens()) {
            String coachName = tokenizer.nextToken();
            if (!(MIN_NAME_LENGTH <= coachName.length() && coachName.length() <= MAX_NAME_LENGTH))
                throw new CustomIllegalArgumentException("사용자 이름은 2~4글자여야 합니다.");
            coachNames.add(coachName);
        }
        if (!(MIN_COACH_NUM <= coachNames.size() && coachNames.size() <= MAX_COACH_NUM))
            throw new CustomIllegalArgumentException("사용자는 2~5명이어야 합니다.");
        return coachNames;
    }

    /**
     * 못먹는 음식을 입력받는다. 잘못된 값이면 에러를 던진다.
     *
     * @return
     */
    public List<String> readCoachDontEatMenus() {
        String menus = Console.readLine();
        StringTokenizer tokenizer = new StringTokenizer(menus, ",");

        List<String> dontEatMenus = new ArrayList<>();
        while (tokenizer.hasMoreTokens()) {
            String menuName = tokenizer.nextToken();
            dontEatMenus.add(menuName);
        }

        if (!(MIN_DONT_ENT_MENU_NUM <= dontEatMenus.size() && dontEatMenus.size() <= MAX_DONT_ENT_MENU_NUM))
            throw new CustomIllegalArgumentException("못먹는 메뉴는 0-2 사이입니다.");

        return dontEatMenus;
    }


}
