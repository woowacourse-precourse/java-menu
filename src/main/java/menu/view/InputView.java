package menu.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    public static final String HAS_NO_COMMA_ERROR = "[ERROR] \",\"로 구분해주세요";

    public String[] readCsv() {
        try {
            String csv = Console.readLine();
            if (!csv.contains(",")&& csv.length() > 1) {
                throw new IllegalArgumentException(HAS_NO_COMMA_ERROR);
            }
            return csv.split(",");
        } catch (IllegalArgumentException notCsv) {
            printErrorBy(notCsv);
            return readCsv();
        }
    }

    public List<String> readNames() {
        try {
            System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
            List<String> names = new ArrayList<>();
            for (String name : readCsv()) {
                names.add(name);
            }
            return names;
        }catch (IllegalArgumentException e){
            printErrorBy(e);
            return readNames();
        }
    }

    public List<String> readNotEatingMenus(String coachName) {
        try {
            System.out.println(coachName + "(이)가 못 먹는 메뉴를 입력해 주세요.");
            List<String> menus = new ArrayList<>();
            for (String menu : readCsv()) {
                menus.add(menu);
            }
            return menus;
        }catch (IllegalArgumentException e){
            printErrorBy(e);
            return readNotEatingMenus(coachName);
        }
    }

    public void printErrorBy(Exception e) {
        System.out.println(e.getMessage());
    }

}
