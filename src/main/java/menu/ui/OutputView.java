package menu.ui;

import java.util.List;
import menu.domain.Coach;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

  /**
   * 처음 게임을 시작했을 때 시작 문구를 출력한다.
   */
  public void printServiceStart() {
    System.out.println("점심 메뉴 추천을 시작합니다.");
  }

  /**
   * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
   * <p>
   * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
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
    System.out.println("[ 카테고리 | 한식 | 한식 | 일식 | 중식 | 아시안 ]");
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