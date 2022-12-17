package menu.tool;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
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
      List<String> menuList=selectMenuList();
      coach.addMenuList(day, menuList);
    }

  }

  /**
   * 한 요일에 대한 메뉴를 선택하는 메서드
   *
   */
  public static List<String> selectMenuList(){
    List<Category> categoryList=ServiceRepository.getCategoryList();
    List<String> result=new ArrayList<>();
    for(Category category:categoryList){
      //특정 카테고리 내 메뉴 목록
      String[] menuList=ServiceRepository.getMenuList(category);
      result.add(selectMenu(result,menuList));
    }
    return result;

  }
  private static String selectMenu(List<String> result, String[] menuList){
    String selectedMenu="";
    while(true){
      selectedMenu=menuList[Randoms.pickNumberInRange(0,menuList.length-1)];
      if(!result.contains(selectedMenu)) break;
    }
    return selectedMenu;


  }


}
