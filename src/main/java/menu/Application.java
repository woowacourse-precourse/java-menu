package menu;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView.printStart();
        List<String> coachName = inputView.readCoachName();
        List<Coach> coach = new ArrayList<>();
        for (String each : coachName) {
            coach.add(inputView.readDislikeFood(each));
        }
        Controller controller = new Controller(coachName, coach);
        controller.start();
        OutputView.printEnd();
    }
}
