package menu;

import java.util.ArrayList;
import java.util.List;
import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Day;
import menu.repository.ServiceRepository;
import menu.tool.MenuSelector;
import menu.ui.InputView;
import menu.ui.OutputView;

public class MenuService {

  final InputView input = new InputView();
  final OutputView output = new OutputView();
  private ServiceRepository serviceRepository;

  /**
   * 전체 서비스를 수행하는 메서드
   */
  public void startService() {
    serviceRepository = new ServiceRepository();
    output.printServiceStart();

    List<Coach> coachList = input.readCoachName();

    setExMenuList(coachList);
    executeService(coachList);

    output.printResult(coachList);
  }

  /**
   * 코치 별 먹지 못하는 음식 목록을 설정하는 메서드
   * @param coachList
   */
  public void setExMenuList(List<Coach> coachList) {
    for (int i = 0; i < coachList.size(); i++) {
      List<String> exMenuList = List.of(input.readExcludedMenu(coachList.get(i)));
      coachList.get(i).setExcludedMenu(exMenuList);
    }
  }

  /**
   * 실제 코치/요일별 메뉴 선택이 일어나는 메서드
   * @param coachList
   */
  public void executeService(List<Coach> coachList) {
    for (Day day : Day.values()) {
      MenuSelector.selectAllMenu(coachList,day);
    }
  }
}


