package menu;

import coach.Managecoach;

import java.util.List;

public class Application {
    static Managecoach makeCoachList(List<String> coachNameList) {
        return new Managecoach(coachNameList);
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            View view = new View();
            view.startGame();
            List<String> coachNameList = view.inputCoachName();
            Managecoach coachList = makeCoachList(coachNameList);
            for(int coachCnt= 0; coachCnt <coachList.getCoachList().size(); coachCnt++){
                view.inputCoachHateFood(coachList.getCoachList().get(coachCnt).getName());
            }
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }
}
