package menu.tool;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Day;
import menu.repository.ServiceRepository;

public class MenuSelector {

  /**
   * 한 코치의 전체 요일에 대한 메뉴를 선택하는 메서드
   * @param coach
   */
  public static void selectAllMenu(Coach coach){
    for(Day day:Day.values()){
      Category category=ServiceRepository.getCategoryList().get(day.getDay()-1);
      String menu=selectMenu(category, coach.getMenuList().values());
      coach.addMenuList(day, menu);
    }
  }

  /**
   * 카테고리 내에서 메뉴를 하나 선택하여 반환하는 메서드
   * @param category
   * @param result
   * @return
   */
  private static String selectMenu(Category category, Collection result){
    String[] menuList=ServiceRepository.getMenuList(category);
    String selectedMenu="";
    while(true){
      selectedMenu=menuList[Randoms.pickNumberInRange(0,menuList.length-1)];
      if(!result.contains(selectedMenu)) break;
    }
    return selectedMenu;


  }


}
