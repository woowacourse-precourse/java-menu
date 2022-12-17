package menu.Controller;

import menu.Model.Coach;
import menu.Model.Coaches;
import menu.Util.Validator;
import menu.View.InputView;

import java.util.List;

public class InitController {
    private final Coaches coaches;

    public InitController(Coaches coaches) {
        this.coaches = coaches;
    }

    public void initCoaches() {
        List<String> coachNames = initCoachName();
        for (String e : coachNames) {
            Coach coach = new Coach(e);
            this.coaches.addCoach(coach);
        }
    }

    public void initNotPreferMenus() {
        for (Coach coach : coaches.getCoaches()) {
            initNotPreferMenu(coach);
        }
    }

    public List<String> initNotPreferMenu(Coach coach) {
        try {
            String input = InputView.requestNotPreferMenu(coach.getName());
            List<String> notPreferMenuNames = Validator.notPreferMenuCheck(input);
            for (String e : notPreferMenuNames) {
                coach.addNotPreferMenu(e);
            }
            return notPreferMenuNames;
        } catch (Exception e) {
            System.out.println(e);
            return initNotPreferMenu(coach);
        }
    }

    public List<String> initCoachName() {
        try {
            String input = InputView.requestCoachName();
            return Validator.coachNameCheck(input);
        } catch (Exception e) {
            System.out.println(e);
            return initCoachName();
        }
    }
}
