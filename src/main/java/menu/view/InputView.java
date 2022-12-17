package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.validation.InputValidation;

public class InputView {

  private InputValidation inputValidation = new InputValidation();

  public String readCoachesName() {
    String input = null;
    while (true) {
      try {
        input = Console.readLine();
        inputValidation.validateCoachesName(input);
        break;
      } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
      }
    }
    return input;
  }

  public String readFoodCantEat() {
    String input = null;
    while (true) {
      try {
        input = Console.readLine();
        inputValidation.validateHateFood(input);
        break;
      } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
      }
    }
    return input;
  }
}
