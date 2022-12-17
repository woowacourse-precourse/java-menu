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
   * @param coachList
   * @param day
   *
   */
  public static void selectAllMenu(List<Coach> coachList, Day day){
    for(Coach coach:coachList){
      Category category=ServiceRepository.getCategoryList().get(day.getDay()-1);
      String menu=selectMenu(category, coach);
      coach.addMenuList(day, menu);
      System.out.println(category.getCategory()+day+menu);
    }
  }

  /**
   * 카테고리 내에서 메뉴를 하나 선택하여 반환하는 메서드
   * @param category
   * @param coach
   * @return
   */
  private static String selectMenu(Category category, Coach coach){
    Collection<String> result=coach.getMenuList().values();
    List<String> menuList= List.of(ServiceRepository.getMenuList(category));
    System.out.println(menuList);
    String selectedMenu="";
    while(true){
      selectedMenu=Randoms.shuffle(menuList).get(0);
      if(!(result.contains(selectedMenu)||coach.getExcludedMenu().contains(selectedMenu))) break;
    }
    return selectedMenu;


  }


}
