package menu;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        List<String> coachName = inputView.readCoachName();
        List<Coach> coach = inputView.readDislikeFood(coachName);


    }
}
