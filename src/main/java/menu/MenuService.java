package menu;

import java.util.ArrayList;
import java.util.List;
import menu.domain.Category;
import menu.domain.Coach;
import menu.tool.CategoryMaker;
import menu.ui.InputView;
import menu.ui.OutputView;

public class MenuService {

  List<Category> categoryList = new ArrayList<>();
  final InputView input = new InputView();
  final OutputView output = new OutputView();
  final CategoryMaker categoryMaker = new CategoryMaker();

  public void startService() {
    output.printServiceStart();

    List<Coach> coachList = input.readCoachName();

    for (int i = 0; i < coachList.size(); i++) {
      String[] exMenuList = input.readExcludedMenu(coachList.get(i));
      coachList.get(i).setExcludedMenu(exMenuList);
    }
    setCategoryList(categoryMaker.categoryMaker());



  }

  public void setCategoryList(List<Category> categoryList) {
    this.categoryList = categoryList;
  }
}

