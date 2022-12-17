package menu;

import java.util.function.Function;

public enum GuideMessage {
  START("점심 메뉴 추천을 시작합니다."),
  INPUT_COACH("코치의 이름을 입력해 주세요. (, 로 구분)"),
  INPUT_FOOD_CANT_EAT(x -> x + "(이)가 못 먹는 메뉴를 입력해 주세요."),
  OUTPUT_RECOMMENDATION_RESULT("메뉴 추천 결과입니다.\n[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]"),
  OUTPUT_COMPLETE_RECOMMENDATION("추천을 완료했습니다.");

  private String message;
  private Function<String, String> template;

  GuideMessage(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }

  GuideMessage(Function<String, String> template) {
    this.template = template;
  }

  public String print(String rateOfReturn) {
    return this.template.apply(rateOfReturn);
  }
}
