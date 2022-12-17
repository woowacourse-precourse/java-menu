package menu.ui;

import java.util.List;
import menu.domain.Category;
import menu.domain.Coach;
import menu.repository.ServiceRepository;

public class OutputView {

  /**
   * 서비스를 실행시켰을 때 시작 문구를 출력한다.
   */
  public void printServiceStart() {
    System.out.println("점심 메뉴 추천을 시작합니다.");
  }

  /**
   * 메뉴 추천 결과를 출력한다.
   */
  public void printResult(List<Coach> coachList) {
    System.out.println("메뉴 추천 결과입니다.");
    printDay();
    printCategory();
    printCoachMenuList(coachList);
    System.out.println("추천을 완료했습니다.");

  }

  private void printDay() {
    System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
  }

  private void printCategory() {
    System.out.print("[ 카테고리");
    for(Category category:ServiceRepository.getCategoryList()){
      System.out.print(" | "+category.getCategory());
    }
    System.out.println(" ]");

  }
  private void printCoachMenuList(List<Coach> coachList) {
    for (int i = 0; i < coachList.size(); i++) {
      System.out.println(coachList.get(i));
    }
  }

  /**
   * 양식에 맞춰 에러 문구를 출력한다.
   *
   * @param e 에러 메세지 정보를 가지고 있는 Exception 객체
   */
  public static void printError(Exception e) {
    System.out.println("[ERROR] " + e.getMessage());
  }
}