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
            for(int cCnt= 0; cCnt <coachList.getCoachList().size(); cCnt++){
                List<String> hateList = view.inputCoachHateFood(coachList.getCoachList().get(cCnt).getName());
                coachList.getCoachList().get(cCnt).updateHateFood(hateList);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }
}
