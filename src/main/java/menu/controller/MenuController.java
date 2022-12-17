package menu.controller;

import java.util.ArrayList;
import java.util.List;

import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    List<String> coaches = new ArrayList<>();
    List<String> coachNotEat = new ArrayList<>();

    public void run() {
        outputView.printServiceStart();
        outputView.printInputCoachName();
        coaches = inputView.readCoachName();
        
        for (String coach : coaches) {
            outputView.printInputCoachNotEat(coach);
            coachNotEat = inputView.readCoachNotEat();
            System.out.println(coachNotEat);
        }
        outputView.printServiceResult();
        recommend();
        outputView.printServiceEnd();
    }

    public void recommend() {

    }

}
