package menu;

import camp.nextstep.edu.missionutils.Randoms;
import coach.Managecoach;

import java.util.ArrayList;
import java.util.List;

public class Application {
    static Managecoach makeCoachList(List<String> coachNameList) {
        return new Managecoach(coachNameList);
    }

    static void recommend(Managecoach managecoach) {
        List<Integer> category = new ArrayList<>(List.of(0, 0, 0, 0, 0));
        for (int day = 0; day < 5; day++) {
            int todayCategory = categoryRecommend(category);
            category.set(day, todayCategory);
        }
        System.out.println(category);
    }

    static int categoryRecommend(List<Integer> category) {
        int todayCate;
        do {
            todayCate = Randoms.pickNumberInRange(1, 5);
        } while (!checkCategory(category, todayCate));
        return todayCate;
    }

    static boolean checkCategory(List<Integer> week, int today) {
        int cnt = 0;
        for (int day : week) {
            if (day == today) {
                cnt++;
            }
        }
        return cnt <= 2;
    }


    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            View view = new View();
            view.startGame();
            List<String> coachNameList = view.inputCoachName();
            Managecoach coachList = makeCoachList(coachNameList);
            for (int cCnt = 0; cCnt < coachList.getCoachList().size(); cCnt++) {
                List<String> hateList = view.inputCoachHateFood(coachList.getCoachList().get(cCnt).getName());
                coachList.getCoachList().get(cCnt).updateHateFood(hateList);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }
}
