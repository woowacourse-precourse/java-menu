package menu.view;

import menu.utils.constants.OutputMessage;

public class OutputView {
    public static OutputView instance = new OutputView();

    public static OutputView getInstance(){
        return instance;
    }

    public void printStartMessage(){
        System.out.println(OutputMessage.RECOMMENDATION_START.getMessage());
    }
}
