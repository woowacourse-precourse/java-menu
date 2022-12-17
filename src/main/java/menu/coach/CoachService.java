package menu.coach;

import java.util.ArrayList;
import java.util.List;

public class CoachService {

    private static List<Coach> coaches = new ArrayList<>(); // 코치들

    public static List<Coach> getCoaches() {
        return coaches;
    }

    // 코치 이름 입력받기
    public static void setCoaches() {
        // InputView 호출
        setCoachesCannotEat();
    }

    // 못 먹는 메뉴 입력받기
    private static void setCoachesCannotEat() {
        // InputView 호출
    }

}
