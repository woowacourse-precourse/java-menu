package menu.repository;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import menu.domain.Category;

public class ServiceRepository {
  static List<Category> categoryList=new ArrayList<>();
  static HashMap<Category, String[]> menuList = new HashMap<>();
  public void ServiceRepository(){
    makeCategoryList();
    makeMenuList();
  }

  private void makeCategoryList(){
    List<Category> categoryList=new ArrayList<>();
    List<Integer> categoryIDList=new ArrayList<>();
    while(categoryList.size()<5){
      int category = Randoms.pickNumberInRange(1, 5);
      if(Collections.frequency(categoryIDList,category)<2){
        categoryIDList.add(category);
        categoryList.add(Category.values()[category-1]);
      }
    }
    this.categoryList=categoryList;
  }


  public void makeMenuList() {
    menuList.put(Category.Japan,
        new String[]{"규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼"});
    menuList.put(Category.Korean,
        new String[]{"김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음"});
    menuList.put(Category.China,
        new String[]{"깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채"});
    menuList.put(Category.Asian,
        new String[]{"팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜"});
    menuList.put(Category.Western,
        new String[]{"라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니"});
  }


  public static List<Category> getCategoryList() {
    return categoryList;
  }
  public static HashMap<Category, String[]> getMenuList() {
    return menuList;
  }
  public static String[] getMenuList(Category category) {
    return menuList.get(category);
  }

}
