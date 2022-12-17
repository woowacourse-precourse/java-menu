package menu;

import camp.nextstep.edu.missionutils.Randoms;
import coach.Coach;
import coach.Managecoach;

import java.util.ArrayList;
import java.util.List;

public class Application {
    static Managecoach makeCoachList(List<String> coachNameList) {
        return new Managecoach(coachNameList);
    }

    static List<Integer> recommend(Managecoach managecoach, FoodList foodList) {
        List<Integer> category = new ArrayList<>(List.of(0, 0, 0, 0, 0));
        for (int day = 0; day < 5; day++) {
            int todayCategory = categoryRecommend(category);
            category.set(day, todayCategory);
            foodRecommend(managecoach, todayCategory, foodList);
        }
        return category;
    }

    static void foodRecommend(Managecoach managecoach, int category, FoodList foodList) {
        for (Coach coach : managecoach.getCoachList()) {
            coach.updateAteFood(pickMenu(coach, foodList, category));
        }
    }

    static String pickMenu(Coach coach, FoodList foodList, int category) {
        String menu;
        while (true) {
            menu = Randoms.shuffle(foodList.foods.get(category - 1)).get(0);
            if (!coach.getAteFood().contains(menu) && !coach.getHateFood().contains(menu))
                break;
        }
        return menu;
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
        return cnt < 2;
    }

    static void setCoachHate(Managecoach coachList, View view) {
        for (int cCnt = 0; cCnt < coachList.getCoachList().size(); cCnt++) {
            List<String> hateList = view.inputCoachHateFood(coachList.getCoachList().get(cCnt).getName());
            coachList.getCoachList().get(cCnt).updateHateFood(hateList);
        }
    }


    public static void main(String[] args) {
        try {
            View view = new View();
            view.startGame();
            FoodList foodList = new FoodList();
            List<String> coachNameList = view.inputCoachName();
            Managecoach coachList = makeCoachList(coachNameList);
            setCoachHate(coachList, view);
            List<Integer> weekCategory = recommend(coachList, foodList);
            view.printRecommendResult(coachList, weekCategory);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }
}
