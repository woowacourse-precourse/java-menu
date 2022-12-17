package menu.tool;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import menu.domain.Category;
import menu.domain.Coach;
import menu.repository.MenuRepository;
import menu.repository.ServiceRepository;

public class MenuSelector {
  public static void selectMenuList(Coach coach){
    List<Category> categoryList=ServiceRepository.getCategoryList();
    List<String> result=new ArrayList<>();
    for(Category category:categoryList){
      //특정 카테고리 내 메뉴 목록
      String[] menuList=ServiceRepository.getMenuList(category);
      result.add(selectMenu(result,menuList));
    }
    coach.setMenuList(result);

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
