package menu.coach;

import menu.view.InputView;
import menu.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class CoachService {

    private static List<Coach> coaches = new ArrayList<>(); // 코치들

    public static List<Coach> getCoaches() {
        return coaches;
    }

    /**
     * 코치 이름 입력받기
     */
    public static void setCoaches() {
        // InputView 호출
        String[] coachesName;
        while (true) {
            coachesName = askCoachesName();
            if (coachesName != null) {
                break;
            }
        }
        for (String coachName : coachesName) {
            coaches.add(new Coach(coachName));
        }
        setCoachesCannotEat();
    }

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
     * 못 먹는 메뉴 입력받기
     */
    private static void setCoachesCannotEat() {
        for (Coach coach : coaches) {
            String[] cannotEats;
            while (true) {
                cannotEats = askCoachesCannotEats(coach);
                if (cannotEats != null) {
                    break;
                }
            }
            for (String cannotEat : cannotEats) {
                coach.addMenusCannotEats(cannotEat);
            }
        }
    }

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
