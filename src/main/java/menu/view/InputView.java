package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.category.Category;

import java.util.NoSuchElementException;

public class InputView {

    /**
     * TODO: 코치 이름 입력받기
     *
     * @return ","으로 나눈 코치들 이름 목록
     */
    public static String[] setCoachesName() {
        String coachesName_input;
        try {
            coachesName_input = Console.readLine();
        } catch (NoSuchElementException exception) {  // 입력이 없을 경우 ("")
            throw new IllegalArgumentException();
        }
        String[] coachesName = coachesName_input.split(",");
        if (!checkCoachesName_number(coachesName) || !checkCoachesName_value(coachesName))
            throw new IllegalArgumentException();
        return coachesName;
    }

    // 코치들의 수 : 최소 2명, 최대 5명
    private static boolean checkCoachesName_number(String[] coachesName) {
        return coachesName.length >= 1 && coachesName.length <= 5;
    }

    // 이름 : 최소 2글자, 최대 4글자
    private static boolean checkCoachesName_value(String[] coachesName) {
        for (String coachName : coachesName) {
            if (coachName.length() < 2 || coachName.length() > 4) {
                return false;
            }
        }
        return true;
    }

    /**
     * TODO: 코치가 못 먹는 메뉴 입력받기
     *
     * @return ","으로 나눈 코치가 못 먹는 메뉴 목록
     */
    public static String[] setCoachesCannotEats() {
        String coachCannotEats_input;
        try {
            coachCannotEats_input = Console.readLine();
        } catch (NoSuchElementException exception) {  // 입력이 없을 경우 ("")
            return new String[]{""};
        }
        String[] coachCannotEats = coachCannotEats_input.split(",");
        if (!checkCoachCannotEats_number(coachCannotEats) || !checkCoachCannotEats_value(coachCannotEats)) {
            throw new IllegalArgumentException();
        }
        return coachCannotEats;
    }

    // 못 먹는 메뉴의 수 : 최소 0개, 최대 2개
    private static boolean checkCoachCannotEats_number(String[] coachCannotEat) {
        return coachCannotEat.length <= 2;
    }

    // 존재하지 않는 메뉴인지 확인
    private static boolean checkCoachCannotEats_value(String[] coachCannotEats) {
        for (String coachCannotEat : coachCannotEats) {
            if (Category.isInMenu(coachCannotEat)) {
                return true;
            }
        }
        return false;
    }

}
