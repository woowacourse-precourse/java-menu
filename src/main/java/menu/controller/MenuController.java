package menu.controller;

import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {

  InputView inputView = new InputView();
  OutputView outputView = new OutputView();

  public void run() {
    outputView.printStart();
    String coachesName = inputView.readCoachesName();

  }
}
