package menu;

import java.util.ArrayList;
import java.util.List;
import menu.coach.Coaches;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {

    private final InputView inputView;
    private final OutputView outputView;

    public MenuController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        outputView.printStartMessage();
        inputCoaches();
        inputCoachesHateFood();

        Menus.init();

        RecommendMenu rm = new RecommendMenu();
        outputView.printResult(rm.getCategory());
        arrToList(rm.getResult());
        outputView.printEndMessage();
    }

    private void inputCoaches() {
        try {
            Coaches.listToCoaches(inputFromView());
        } catch (IllegalArgumentException error) {
            outputView.printErrorMessage(error.getMessage());
            Coaches.init();
            inputCoaches();
        }
    }

    private void inputCoachesHateFood() {
        try {
            inputView.inputCoachesHateFoods();
        } catch (IllegalArgumentException error) {
            outputView.printErrorMessage(error.getMessage());
            inputCoachesHateFood();
        }
    }

    private List<String> inputFromView() {
        try {
            return inputView.inputCoaches();
        } catch (IllegalArgumentException error) {
            outputView.printErrorMessage(error.getMessage());
            return inputFromView();
        }
    }


    private void arrToList(String[][] arr) {
        for (int j = 0; j < Coaches.getCoaches().size(); j++) {
            List<String> result = new ArrayList<>();
            for (int i = 0; i < 6; i++) {
                result.add(arr[j][i]);
            }
            outputView.printRecommendMenu(result);
        }
    }
}
