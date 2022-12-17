package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.validation.InputValidation;

public class InputView {

  private InputValidation inputValidation = new InputValidation();

  public String readCoachesName() {
    String input = Console.readLine();
    inputValidation.validateCoachesName(input);
    return input;
  }

  public String readFoodCantEat() {
    String input = Console.readLine();
    inputValidation.validateHateFood(input);
    return input;
  }
}
