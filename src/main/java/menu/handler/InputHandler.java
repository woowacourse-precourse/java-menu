package menu.handler;

import menu.domain.Coach;
import menu.view.InputView;

public class InputHandler {

    private final InputView inputView;

    public InputHandler(InputView inputView) {
        this.inputView = inputView;
    }

    public Coach readCoachName() {
        try {
            String input = inputView.readName();
            return new Coach(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readCoachName();
        }
    }

    public void readCoachCanNotEat(Coach coach) {
        try {
            for (int i = 0; i < coach.getNames().size(); i++) {
                String coachName = coach.getNames().get(i);
                String input = inputView.readCanNotEat(coachName);

                coach.setCanNotEat(coachName, input);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            readCoachCanNotEat(coach);
        }
    }
}
