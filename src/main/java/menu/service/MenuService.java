package menu.service;

import menu.InputView;
import menu.OutputView;

public class MenuService {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    public String[] askCoachNames() {
        while (true) {
            try {
                return inputView.readCoachName();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String[] askInedibleFoodName(String coachName) {
        while (true) {
            try {
                return inputView.readInedibleFoodName(coachName);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }




    public void printServiceStart() {
        outputView.printStart();
    }

    public void printServiceExit() {
        outputView.printResult();
    }

}
