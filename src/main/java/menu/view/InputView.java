package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.category.CategoryService;
import menu.coach.Coach;

import java.util.NoSuchElementException;

public class InputView {

    /**
     * 코치 이름 입력받기
     *
     * @return
     */
    public static String[] setCoachesName() {
        String coachesName_input;
        try {
            coachesName_input = Console.readLine();
        } catch (NoSuchElementException exception) {  // 입력이 없을 경우 ("")
            throw new IllegalArgumentException();
        }
        String[] coachesName = coachesName_input.split(", ");
        if (!checkCoachesName_number(coachesName) || !checkCoachesName_value(coachesName))
            throw new IllegalStateException();
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
     * 코치가 못 먹는 메뉴 입력받기
     * @param coach
     * @return
     */
    public static String[] setCoachesCannotEats() {
        String coachCannotEats_input = Console.readLine();
        String[] coachCannotEats = coachCannotEats_input.split(", ");
        if (!checkCoachCannotEats_number(coachCannotEats) || !checkCoachCannotEats_value(coachCannotEats)) {
            throw new IllegalStateException();
        }
        return coachCannotEats;
    }

    // 못 먹는 메뉴의 수 : 최소 0개, 최대 2개
    private static boolean checkCoachCannotEats_number(String[] coachCannotEat) {
        return coachCannotEat.length <= 2;
    }

    // 없는 메뉴일 경우
    private static boolean checkCoachCannotEats_value(String[] coachCannotEats) {
        for (String coachCannotEat : coachCannotEats) {
            if (CategoryService.isInMenu(coachCannotEat)) {
                return true;
            }
        }
        return false;
    }

}
