package menu;

import java.util.ArrayList;
import java.util.List;

public class CoachRepo {
    List<Coach> coachList = new ArrayList<>();

    public void setCoachList(String scanCoachName) {
        String coachNameList[] = scanCoachName.split(",");
        for (int i=0; i<coachNameList.length; i++){
            Coach coach = new Coach(coachNameList[i]);
            coachList.add(coach);
        }
    }
    public void setCoachCannotEatMenu(String coachName, String scanCannotEatMenu) {
        if(!scanCannotEatMenu.equals("")){
            String cannotEatMenuList[] = scanCannotEatMenu.split(",");
            Coach targetCoach = getTargetCoach(coachName);
            for (int i=0; i<cannotEatMenuList.length; i++){
                targetCoach.cannotEatMenuList.add(refreshString(cannotEatMenuList[i]));
            }
        }
    }

    private String refreshString(String s) {
        if (s.charAt(0) == ' ') {
            s=s.substring(1);
        }
        if (s.charAt(s.length()-1) == ' '){
            s=s.substring(0,s.length()-1);
        }
        return s;
    }

    private Coach getTargetCoach(String coachName) {
        Coach targetCoach = null;
        for (Coach coach : coachList){
            if (coach.name == coachName){
                targetCoach = coach;
                break;
            }
        }
        return targetCoach;
    }
}
