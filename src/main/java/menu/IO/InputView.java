package menu.IO;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class InputView {
    final int MIN_NAME_LENGTH = 2;
    final int MAX_NAME_LENGTH = 4;
    final int MIN_DONT_ENT_MENU_NUM = 0;
    final int MAX_DONT_ENT_MENU_NUM = 2;

    public List<String> readCoachNames() {
        String names = Console.readLine();
        StringTokenizer tokenizer = new StringTokenizer(names, ",");

        List<String> coachNames = new ArrayList<>();
        while (tokenizer.hasMoreTokens()) {
            String coachName = tokenizer.nextToken();
            if (!(MIN_NAME_LENGTH <= coachName.length() && coachName.length() <= MAX_NAME_LENGTH))
                throw new IllegalArgumentException("[ERROR] 사용자 이름은 2~4글자여야 합니다.");
            coachNames.add(coachName);
        }

        return coachNames;
    }

    public List<String> readCoachDontEatMenus() {
        String menus = Console.readLine();
        StringTokenizer tokenizer = new StringTokenizer(menus, ",");

        List<String> dontEatMenus = new ArrayList<>();
        while (tokenizer.hasMoreTokens()) {
            String menuName = tokenizer.nextToken();
            dontEatMenus.add(menuName);
        }

        if (!(MIN_DONT_ENT_MENU_NUM <= dontEatMenus.size() && dontEatMenus.size() <= MAX_DONT_ENT_MENU_NUM))
            throw new IllegalArgumentException("[ERROR] 못먹는 메뉴는 0-2 사이입니다.");

        return dontEatMenus;
    }


}
