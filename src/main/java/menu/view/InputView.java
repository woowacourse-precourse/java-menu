package menu.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static menu.view.OutputView.printErrorMessage;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import menu.domain.Coach;
import menu.domain.Menu;

public class InputView {

  private static final String INPUT_COACHES_MESSAGE = "코치의 이름을 입력해 주세요. (, 로 구분)";
  private static final String COACHES_SIZE_ERROR = "코치는 2명 이상 5명 이하로 식사를 합니다.";
  private static final String CANNOT_EAT = "%s(이)가 못 먹는 메뉴를 입력해 주세요.";
  private static final String CANNOT_EAT_SIZE_ERROR = "코치가 못먹는 음식은 2개 이하 입니다.";


  public List<Coach> readCoaches() {
    while (true) {
      try {
        System.out.println(INPUT_COACHES_MESSAGE);
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
      throw new IllegalArgumentException(COACHES_SIZE_ERROR);
    }
  }

  public List<String> readCannotEatMenus() {
    while (true) {
      try {
        System.out.println(CANNOT_EAT);
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
      throw new IllegalArgumentException(CANNOT_EAT_SIZE_ERROR);
    }
  }

  private List<String> getList(String input) {
    if (input.length() == 0) {
      return Collections.emptyList();
    }
    return Arrays.asList(input.split(","));
  }

}
