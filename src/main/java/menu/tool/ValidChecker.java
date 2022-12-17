package menu.tool;

public class ValidChecker {

  /**
   * 입력받은 코치들의 인원 수가 유효한지 검사하는 메서드
   * @param nameList
   * @throws IllegalArgumentException
   */
  public static void checkNumberOfCoach(String[] nameList) throws IllegalArgumentException {
    if (nameList.length < 2) {
      throw new IllegalArgumentException("코치는 최소 2명 이상 입력해야 합니다.");
    }
    if (nameList.length > 5) {
      throw new IllegalArgumentException("코치는 최대 5명 이하 입력해야 합니다.");
    }
  }

  /**
   * 코치들의 이름이 유효한지 검사하는 메서드
   * @param nameList
   * @throws IllegalArgumentException
   */
  public static void checkNameLength(String[] nameList) throws IllegalArgumentException {
    for (int i = 0; i < nameList.length; i++) {
      if (nameList[i].length() < 2) {
        throw new IllegalArgumentException("코치의 이름은 최소 2글자 이상 입력해야 합니다.");
      }
      if (nameList[i].length() > 4) {
        throw new IllegalArgumentException("코치의 이름은 최대 4글자 이하 입력해야 합니다.");
      }
    }
  }

  /**
   * 입력받은 (코치가 먹지 않는)메뉴의 수가 유효한지 검사하는 메서드.
   *
   * @param nameList
   * @throws IllegalArgumentException
   */
  public static void checkMenuList(String[] nameList) throws IllegalArgumentException {
    if (nameList.length > 2) {
      throw new IllegalArgumentException("코치가 먹지 못하는 메뉴는 2개 이하여야 합니다.");
    }
  }
}
