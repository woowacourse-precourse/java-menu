package menu;

import coach.Managecoach;

import java.util.List;

public class Application {
    static void makeCoachList(List<String> coachNameList) {
        Managecoach managecoach = new Managecoach(coachNameList);
        System.out.println(managecoach.getCoachList());
    }


    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            View view = new View();
            view.startGame();
            List<String> coachNameList = view.inputCoachName();
            makeCoachList(coachNameList);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }
}
