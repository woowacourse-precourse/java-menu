package menu.coach;

import menu.view.InputView;
import menu.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class CoachController {

    private static List<Coach> coaches = new ArrayList<>(); // 코치 목록

    public static List<Coach> getCoaches() {
        return coaches;
    }

    /**
     * 코치 목록 초기화
     */
    public static void setCoaches() {
        String[] coachesName;
        while (true) {
            coachesName = askCoachesName();
            if (coachesName != null) break;
        }
        for (String coachName : coachesName) coaches.add(new Coach(coachName));
        setCoachesCannotEat();
    }

    // 코치 이름 입력받기
    private static String[] askCoachesName() {
        OutputView.printSetCoachesName();
        String[] coachesName = null;
        try {
            coachesName = InputView.setCoachesName();
        } catch (IllegalStateException | IllegalArgumentException exception) {
            OutputView.printErrorMessage_setCoachesName();
        }
        return coachesName;
    }

    /**
     * 코치별 못 먹는 메뉴 초기화
     */
    private static void setCoachesCannotEat() {
        for (Coach coach : coaches) {
            String[] cannotEats;
            while (true) {
                cannotEats = askCoachesCannotEats(coach);
                if (cannotEats != null) break;
            }
            for (String cannotEat : cannotEats) coach.addMenusCannotEats(cannotEat);
        }
    }

    // 못 먹는 메뉴 입력받기
    private static String[] askCoachesCannotEats(Coach coach) {
        OutputView.printSetCoachesCannotEat(coach);
        String[] cannotEats = null;
        try {
            cannotEats = InputView.setCoachesCannotEats();
        } catch (IllegalArgumentException exception) {
            OutputView.printErrorMessage_setCoachesCannotEats();
        }
        return cannotEats;
    }

}
