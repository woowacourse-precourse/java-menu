package menu.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static menu.view.ErrorMessage.CANNOT_EAT_SIZE_ERROR;
import static menu.view.OutputMessage.CANNOT_EAT;
import static menu.view.OutputMessage.COACHES_SIZE_ERROR;
import static menu.view.OutputMessage.INPUT_COACHES_MESSAGE;
import static menu.view.OutputView.printErrorMessage;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import menu.domain.Coach;

public class InputView {

  public List<Coach> readCoaches() {
    while (true) {
      try {
        System.out.println(INPUT_COACHES_MESSAGE.getMessage());
        List<String> coachNames = getList(readLine());
        validateCoachNames(coachNames);
        return coachNames.stream().map(Coach::new).collect(Collectors.toList());
      } catch (IllegalArgumentException e) {
        printErrorMessage(e.getMessage());
      }
    }
  }

  private void validateCoachNames(List<String> coachNames) {
    if (coachNames.size() < 2 || coachNames.size() > 5) {
      throw new IllegalArgumentException(COACHES_SIZE_ERROR.getMessage());
    }
  }

  public List<String> readCannotEatMenus(String coachName) {
    while (true) {
      try {
        System.out.println(String.format(CANNOT_EAT.getMessage(), coachName));
        List<String> menus = getList(readLine());
        validateMenus(menus);
        return menus;
      } catch (IllegalArgumentException e) {
        printErrorMessage(e.getMessage());
      }
    }
  }

  private void validateMenus(List<String> coachNames) {
    if (coachNames.size() > 2) {
      throw new IllegalArgumentException(CANNOT_EAT_SIZE_ERROR.getMessage());
    }
  }

  private List<String> getList(String input) {
    if (input.length() == 0) {
      return Collections.emptyList();
    }
    return Arrays.asList(input.split(","));
  }

}
