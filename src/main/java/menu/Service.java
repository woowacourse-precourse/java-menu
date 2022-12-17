package menu;

import java.util.ArrayList;
import java.util.List;
import menu.view.InputView;
import menu.view.OutputView;

public class Service {

    private static final List<Coach> group = new ArrayList();

    public void start() {
        OutputView.start();
    }

    public void getCoaches() {
        OutputView.insertCoaches();
        InputView.insertCoach(this);
    }

    public void addCoach(Coach coach) {
        group.add(coach);
    }
}
