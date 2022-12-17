package menu.controller;

import menu.domain.Party;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.List;

public class PartyController {

    private Party party;

    public PartyController() {
        this.party = new Party();
    }

    public void startGathering() {
        OutputView.printStartMessage();
        OutputView.printNewLine();
        OutputView.printRequestCoachNameMessage();

        List<String> coachNames = InputView.readCoachName();
        party.addCoaches(coachNames);

        for(int i = 0; i < coachNames.size(); i++) {
            OutputView.printRequestCantEatingMessage(coachNames.get(i));
            List<String> cantFoodName = InputView.readCantEatingMenu();
            party.addCoachesCantEatingFood(cantFoodName);
        }
        OutputView.printResultMessage();
        calculate();
        OutputView.printEndMessage();
    }

    public void calculate() {
        party.setFoodCategories();
        party.addFoodPerCoach();
        OutputView.printResult(party.toStringFoodCategories());
        OutputView.printResult(party.recommendResult());
    }
}
