package menu;

import java.util.ArrayList;
import java.util.List;
import menu.View.InputView;
import net.bytebuddy.pool.TypePool;

public class Run {
    List<Coach> coaches = new ArrayList<>();
    List<String> coachesName;

    public Run() {
        while(true) {
            try {
                getInput();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void getInput() {
        coachesName = new InputView().getCoachesName();
        for (int i = 0; i < coachesName.size(); i++) {
            Coach coach = new Coach();
            coach.setName(coachesName.get(i));
            coach.setHateFood(new InputView().getHateFood(coachesName.get(i)));
        }
    }


}
