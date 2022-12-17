package menu;

import java.util.ArrayList;
import java.util.List;
import menu.domain.Category;
import menu.domain.Coach;
import menu.repository.MenuRepository;
import menu.repository.ServiceRepository;
import menu.ui.InputView;
import menu.ui.OutputView;

public class MenuService {

  List<Category> categoryList = new ArrayList<>();
  final InputView input = new InputView();
  final OutputView output = new OutputView();
  final ServiceRepository serviceRepository=new ServiceRepository();
  final MenuRepository menuRepository=new MenuRepository();

  public void startService() {
    output.printServiceStart();

    List<Coach> coachList = input.readCoachName();

    for (int i = 0; i < coachList.size(); i++) {
      String[] exMenuList = input.readExcludedMenu(coachList.get(i));
      coachList.get(i).setExcludedMenu(exMenuList);
    }




  }

  public void setCategoryList(List<Category> categoryList) {
    this.categoryList = categoryList;
  }
}

