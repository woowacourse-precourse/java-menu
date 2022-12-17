package menu.ui;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import menu.domain.Coach;
import menu.tool.ValidChecker;

public class InputView {
    /**
     * 코치들의 이름을 입력받는 메서드.
     */
    public List<Coach> readCoachName() {
      try {
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
        String input = Console.readLine();
        String[] nameList=input.split(",");
        ValidChecker.checkNumberOfCoach(nameList);
        ValidChecker.checkNameLength(nameList);
        List<Coach> coachList= Arrays.stream(nameList).map(Coach::new).collect(
            Collectors.toList());
        return coachList;
      } catch (IllegalArgumentException e) {
        OutputView.printError(e);
        return readCoachName();
      }
    }

    /**
     * 각 코치가 못먹는 메뉴들을 입력받는 메서드
     */
    public String[] readExcludedMenu(Coach coach) {
      try {
        System.out.print(coach.getName());
        System.out.println("(이)가 못 먹는 메뉴를 입력해 주세요.");
        String rawString = Console.readLine();
        String[] menuList=rawString.split(",");
        ValidChecker.checkMenuList(menuList);
        return menuList;
      } catch (IllegalArgumentException e) {
        OutputView.printError(e);
        return readExcludedMenu(coach);
      }
    }


}
