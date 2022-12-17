package menu.controller;

import menu.model.ResultBoard;
import menu.view.OutputView;

public class OutputController {
    private OutputView outputView;

    public OutputController(){
        outputView = new OutputView();
    }

    public void printResult(ResultBoard resultBoard){
        outputView.printResult();
        // reslutBoard name to sting and output view
    }
}
