package menu.domain;

import java.util.HashMap;

public class MenuRepository {

  static HashMap<Category, String[]> menuRepository = new HashMap<>();

  public void MenuRepository() {
    menuRepository.put(Category.Japan,
        new String[]{"규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼"});
    menuRepository.put(Category.Korean,
        new String[]{"김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음"});
    menuRepository.put(Category.China,
        new String[]{"깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채"});
    menuRepository.put(Category.Asian,
        new String[]{"팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜"});
    menuRepository.put(Category.Western,
        new String[]{"라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니"});
  }

  public static HashMap<Category, String[]> getMenuRepository() {
    return menuRepository;
  }

}
