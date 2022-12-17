package menu;

import java.util.List;
import menu.domain.Coach;
import menu.ui.InputView;
import menu.ui.OutputView;

public class MenuService {
  final static InputView input=new InputView();
  final static OutputView output=new OutputView();

  public static void startService() {
    output.printServiceStart();

    List<Coach> coachList=input.readCoachName();

    for(int i=0;i<coachList.size();i++){
      String[] exMenuList=input.readExcludedMenu(coachList.get(i));
      coachList.get(i).setExcludedMenu(exMenuList);
    }

  }
}
