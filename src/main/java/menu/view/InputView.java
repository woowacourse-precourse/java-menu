package menu.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {
    public static List<String> readCoachName() {
        OutputView.printStart();
        List<String> coachs = Arrays.asList(Console.readLine().split(","));
        try {
            validateCoachCount(coachs);
            validateCoachNameLength(coachs);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            coachs = readCoachName();
        }
        return coachs;
    }

    public static List<String> readUnableMenu(String coach){
        OutputView.printUnableMenu(coach);
        List<String> unableMenus = Arrays.asList(Console.readLine().split(","));
        try {
            validateUnableMenuCount(unableMenus);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            unableMenus = readUnableMenu(coach);
        }
        return unableMenus;
    }

    public static void validateUnableMenuCount(List<String> unableMenus){
        if(unableMenus.size() > 2){
            throw new IllegalArgumentException("[ERROR] 먹지 못하는 음식은 최대 2개여야 합니다. ");
        }
    }

    public static void validateCoachNameLength(List<String> coachs) {
        for (String coach:coachs) {
            if(coach.length() < 2 || coach.length() > 4){
                throw new IllegalArgumentException("[ERROR] 코치 이름은 최소 2글자, 최대 4글자로 입력해야 합니다.");
            }
        }
    }

    public static void validateCoachCount(List<String> coachs) {
        if(coachs.size() < 2 || coachs.size() > 5){
            throw new IllegalArgumentException("[ERROR] 코치는 최소 2명 이상, 최대 5명 이하로 입력해야 합니다.");
        }
    }


}
