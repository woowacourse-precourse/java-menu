package menu.repository;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import menu.domain.Category;

public class ServiceRepository {
  static List<Category> categoryList=new ArrayList<>();

  public void ServiceRepository(){
    categoryList=makeCategoryList();
  }

  public List<Category> makeCategoryList(){
    List<Category> categoryList=new ArrayList<>();
    List<Integer> categoryIDList=new ArrayList<>();
    while(categoryList.size()<5){
      int category = Randoms.pickNumberInRange(1, 5);
      if(Collections.frequency(categoryIDList,category)<2){
        categoryIDList.add(category);
        categoryList.add(Category.values()[category-1]);
      }
    }
    return categoryList;
  }

}
